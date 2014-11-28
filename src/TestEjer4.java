import org.jacop.constraints.And;
import org.jacop.constraints.XeqC;
import org.jacop.constraints.XgteqC;
import org.jacop.core.IntVar;
import utccEnums.Operation;
import utcclang.*;


/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Date: 12/11/12
* Time: 9:05
*
*/
public  class TestEjer4 {


    public static void main(String[] args) {

      //the planner.
        Planner testChoice = new Planner();

    //Store output file name
    Store.setFilename("Ejer4 (Modify Execution - Corregida).txt");

    //the variables
    //Note: the declaration of variables can not fixed range, for utilization whit Change.
    //      the variables the increment or decrement can not exceed the range initially declared

    // the instruction change modify the value initial of variables in next unit time.

    IntVar a = Store.getStore().creavarsRetor("a",0,100);
    IntVar b = Store.getStore().creavarsRetor("b",0,100);
    IntVar c = Store.getStore().creavarsRetor("c",0,100);
    IntVar d = Store.getStore().creavarsRetor("d",0,100);
    IntVar[] s =  {a,b,c}, y = {b,c};


    //Declaration of Process.
    Procesos Ini = new Par(new Tell(new XeqC(a,50)), new  Tell(new XeqC(b,20)), new Tell(new XeqC(c,30)),
                           new Tell(new XeqC(d,40)));
    Procesos Default = new Par(new Change(a,50),new Change(b,20),new Change(c,30), new Change(d,40));
    Procesos P = new Par(new Change(a, Operation._DECRE,2),new Change(b, Operation._INCRE,1),
                         new Change(c, Operation._INCRE,1));
    Procesos Q = new Par(new Change(c, Operation._DECRE,1),new Change(d, Operation._INCRE,1));
    Procesos R = new Par(new Change(d, Operation._DECRE,1),new Change(c, Operation._INCRE,1));
    Procesos S = new Par(new Change(d, Operation._DECRE,1),new Change(c, Operation._DECRE,1),
                         new Change(a, Operation._INCRE,1));
    Procesos Combina =  new Bang(new Choice(new AskChoice(new XgteqC(a,2), P ),
                                            new AskChoice(new XgteqC(c,1), Q ),
                                            new AskChoice(new XgteqC(d,1), R ),
                                            new AskChoice(new And (new XgteqC(d,1),new XgteqC(c,1) ), S ) )
                                ) ;

    Procesos React = new Par( Default,Ini,Combina);


        //add process to planner of execution

    testChoice.addProce(React);
    // time unit of execution
    testChoice.setTimeUnit(200);
    //Planner run
    testChoice.run();
    }
}
