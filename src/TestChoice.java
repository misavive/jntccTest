import org.jacop.constraints.*;
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
public  class TestChoice {


    public static void main(String[] args) {

        //the planner.
        Planner testChoice = new Planner();

        //Store output file name
        Store.setFilename("textChoice");

        //the variables
        //Note: the declaration of variables can not fixed range, for utilization whit Change.
        //      the variables the increment or decrement can not exceed the range initially declared

        // the instruction change modify the value initial of variables in next unit time.

        IntVar a = Store.getStore().creavarsRetor("a",0,200);
        IntVar b = Store.getStore().creavarsRetor("b",0,200);
        IntVar c = Store.getStore().creavarsRetor("c",0,200);


        //Declaration of Process.
        Procesos Q = new Par(new Change(a, Operation._DECRE,1), new Change(b,Operation._DECRE,2),
                     new Change(c,Operation._INCRE,1) );
        Procesos Z = new Par(new Change(c,Operation._DECRE,1), new Change(a,Operation._INCRE,2) );

        Procesos reaction = new Bang(new Choice(new AskChoice(new XgteqC(c,1),Q),
                                                new AskChoice(new And(new XgteqC(a,1),new XgteqC(b,1)),Z) )  ) ;

        //add process to planner of execution

        testChoice.addProce(reaction);

        //reading file that adds  constraint of environment.
        Ambient.getAmbient().readerVarsXml("testChoice.xml");
        // time unit of execution
        testChoice.setTimeUnit(2000);
        //Planner run
        testChoice.run();
    }
}
