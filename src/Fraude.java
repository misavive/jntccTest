// ============================================================
// Fraude.java — Real-Time Credit Card Fraud Detection (jNtcc)
// Runtime: jNtccVM.jar  +  JaCoP 3.2
// ============================================================
// Rules / Conventions:
// - Par(...) with N es (varargs)
// - Variables: Store.getStore().creavarsRetor("name", min, max)
// - Tell(...) only receives a Constraint
// - Ask(Constraint cond, Procesos body)
// - AskChoice(Constraint cond, Procesos body)
// - SumWeight(IntVar[] list, int[] weights, IntVar sum)
// - Star(Procesos P, ini, fin) → execute P once in [ini, fin]
// - Star(Procesos P, ini) → execute P once, eventually, between ini and horizon end
// - Execution: planner.addProce(model); planner.run();
// ============================================================

import utcclang.*;
import JaCoP.core.IntVar;
import JaCoP.constraints.SumWeight;
import JaCoP.constraints.XgteqC;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XltC;

public class Fraude {

    public static void main(String[] args) {

        // ---------- Planner & Store ----------
        Planner fraude = new Planner();
        Store.setFilename("Fraude_Store.txt");
        Planner.setTimeUnit(20);  // total horizon of 20 time units

        // ---------- Variables (transaction context) ----------
        IntVar incomingTxn = Store.getStore().creavarsRetor("incomingTxn", 0, 1);
        IntVar txnCountry  = Store.getStore().creavarsRetor("txnCountry",  0, 1);       // 0=LOCAL, 1=FOREIGN
        IntVar txnAmount   = Store.getStore().creavarsRetor("txnAmount",   0, 1_000_000);
        IntVar txnDeltaMin = Store.getStore().creavarsRetor("txnDeltaMin", 0, 60);
        IntVar deviceOk    = Store.getStore().creavarsRetor("deviceOk",    0, 1);

        // ---------- Risk flags ----------
        IntVar riskyGeo      = Store.getStore().creavarsRetor("riskyGeo",      0, 1);
        IntVar riskyVelocity = Store.getStore().creavarsRetor("riskyVelocity", 0, 1);
        IntVar riskyAmount   = Store.getStore().creavarsRetor("riskyAmount",   0, 1);
        IntVar riskyDevice   = Store.getStore().creavarsRetor("riskyDevice",   0, 1);

        // ---------- Decisions ----------
        IntVar approve = Store.getStore().creavarsRetor("approve", 0, 1);
        IntVar flag    = Store.getStore().creavarsRetor("flag",    0, 1);
        IntVar block   = Store.getStore().creavarsRetor("block",   0, 1);

        // ---------- Environment: example transactions ----------
        // Local purchase (safe-ish)
        Procesos txnLocal = new Par(
                new Tell(new XeqC(incomingTxn, 1)),
                new Tell(new XeqC(txnCountry, 0)),       // LOCAL
                new Tell(new XeqC(txnAmount, 120_000)),
                new Tell(new XeqC(txnDeltaMin, 10)),     // far from previous
                new Tell(new XeqC(deviceOk, 1))
        );

        // Foreign purchase, soon after (suspicious pattern)
        Procesos txnForeignSoon = new Par(
                new Tell(new XeqC(incomingTxn, 1)),
                new Tell(new XeqC(txnCountry, 1)),       // FOREIGN
                new Tell(new XeqC(txnAmount, 350_000)),  // high amount
                new Tell(new XeqC(txnDeltaMin, 1)),      // 1 minute from previous
                new Tell(new XeqC(deviceOk, 1))
        );

        // One local txn sometime in [1,3],
        // one foreign txn sometime from unit 2 until the end of the horizon.
        Procesos env = new Par(
                new Star(txnLocal, 1, 3),
                new Star(txnForeignSoon, 2,2)
        );

        // ---------- Reset context + flags each time unit ----------
        // This avoids "ghost" transactions lingering forever.
        Procesos clearContext = new Par(
                new Tell(new XeqC(incomingTxn, 0)),
                new Tell(new XeqC(txnCountry, 0)),
                new Tell(new XeqC(txnAmount, 0)),
                new Tell(new XeqC(txnDeltaMin, 0)),
                new Tell(new XeqC(deviceOk, 1))  // default: device OK
        );

        Procesos clearFlags = new Par(
                new Tell(new XeqC(riskyGeo, 0)),
                new Tell(new XeqC(riskyVelocity, 0)),
                new Tell(new XeqC(riskyAmount, 0)),
                new Tell(new XeqC(riskyDevice, 0)),
                new Tell(new XeqC(approve, 0)),
                new Tell(new XeqC(flag, 0)),
                new Tell(new XeqC(block, 0))
        );

        Procesos resetAll = new Par(clearContext, clearFlags);

        // ---------- Detectors: only react if there is a transaction ----------
        // Geo risk: FOREIGN + delta < 3  => riskyGeo = 1
        Procesos geoDetector =
                new Ask(
                        new XeqC(incomingTxn, 1),
                        new Ask(
                                new XeqC(txnCountry, 1),
                                new Ask(
                                        new XltC(txnDeltaMin, 3),
                                        new Tell(new XeqC(riskyGeo, 1))
                                )
                        )
                );

        // Velocity risk: any txn with delta < 3 => riskyVelocity = 1
        Procesos velocityDetector =
                new Ask(
                        new XeqC(incomingTxn, 1),
                        new Ask(
                                new XltC(txnDeltaMin, 3),
                                new Tell(new XeqC(riskyVelocity, 1))
                        )
                );

        // Amount risk: amount ≥ 200 000 => riskyAmount = 1
        Procesos amountDetector =
                new Ask(
                        new XeqC(incomingTxn, 1),
                        new Ask(
                                new XgteqC(txnAmount, 200_000),
                                new Tell(new XeqC(riskyAmount, 1))
                        )
                );

        // Device risk: deviceOk == 0 => riskyDevice = 1
        Procesos deviceDetector =
                new Ask(
                        new XeqC(incomingTxn, 1),
                        new Ask(
                                new XeqC(deviceOk, 0),
                                new Tell(new XeqC(riskyDevice, 1))
                        )
                );

        // ---------- Aggregation with SumWeight ----------
        IntVar[] risks   = new IntVar[] {riskyGeo, riskyVelocity, riskyAmount, riskyDevice};
        int[] weights    = new int[]   {1,        1,             1,            1};
        IntVar sumAll    = Store.getStore().creavarsRetor("sumAll", 0, 4);

        Procesos sumRisks = new Tell(new SumWeight(risks, weights, sumAll));

        // ---------- Decision (Choice + AskChoice) ----------
        // Business rule:
        // - If sumAll >= 2  → block
        // - Else if sumAll >= 1 → flag
        // - Else (sumAll == 0) → approve
        Procesos decision = new Choice(
                new AskChoice(
                        new XgteqC(sumAll, 2),
                        new Tell(new XeqC(block, 1))
                ),
                new AskChoice(
                        new XgteqC(sumAll, 1),
                        new Tell(new XeqC(flag, 1))
                ),
                new AskChoice(
                        new XeqC(sumAll, 0),
                        new Tell(new XeqC(approve, 1))
                )
        );

        // ---------- Continuous monitoring (Bang) ----------
        Procesos monitors = new Bang(
                new Par(
                        resetAll,
                        geoDetector,
                        velocityDetector,
                        amountDetector,
                        deviceDetector,
                        sumRisks,
                        decision
                )
        );

        // ---------- Full model and execution ----------
        Procesos model = new Par(env, monitors);
        fraude.addProce(model);
        fraude.run();

        System.out.println("FraudRT model finished. Check FraudRT_Store.txt for Store evolution.");
    }}
