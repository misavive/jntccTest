
/**
 * Created with IntelliJ IDEA.
 * By: Misael Viveros Castro.
 * Master Student University Javeriana Cali.
 *
 */


import org.jacop.constraints.*;
import org.jacop.core.IntVar;
import utcclang.*;


 public  class Example {

    public static void main(String[] args) {

        //the planner.
        Planner jntccExample = new Planner();

        //Store output file name
        Store.setFilename("Example");
        //the variables
        //Note: the declaration of variables can not fixed range, for utilization whit Change.
        //      the variables the increment or decrement can not exceed the range initially declared

        // the instruction change modify the value initial of variables in next unit time.

        IntVar a = Store.getStore().creavarsRetor("a",0,120);
        IntVar b = Store.getStore().creavarsRetor("b",0,300);

        //Declaration of Process.
        Procesos P = new Bang(new Par(new Tell(new XgtC(a,10) ),
                                      new Tell(new XlteqC(b,180) )
                                     )
                             );

        Procesos Q = new Bang( new Unless(new XltC(b,200), new Tell(new XeqC(a,50) )
                                          )
                             );
        Procesos R = new Par(new Star(Q,60,120),             //--> la Unidad final Es Mayor a las unidades de ejecución.
                             new Star(Q,30,90)
                            );

        Procesos reaction = new Par(P,R);
        //add process to planner of execution

        jntccExample.addProce(reaction);
        // time unit of execution
        jntccExample.setTimeUnit(100);
        //Planner run
        jntccExample.run();
    }
}