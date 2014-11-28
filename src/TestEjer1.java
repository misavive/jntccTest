import org.jacop.constraints.XeqC;
import org.jacop.constraints.XgtC;
import org.jacop.constraints.XltC;
import org.jacop.core.IntVar;
import utcclang.*;
/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Date: 12/11/12
* Time: 9:05
*
*/
public  class TestEjer1 {


    public static void main(String[] args) {

      //the planner.
        Planner testChoice = new Planner();

    //Store output file name
        Store.setFilename("Ejer1");


        //the variables
    //Note: the declaration of variables can not fixed range, for utilization whit Change.
    //      the variables the increment or decrement can not exceed the range initially declared

    // the instruction change modify the value initial of variables in next unit time.

    IntVar a = Store.getStore().creavarsRetor("a",0,100);
    IntVar b = Store.getStore().creavarsRetor("b",0,100);


    //Declaration of Process.
        Procesos P = new Bang(new Tell(new XgtC(a,10)) );
        Procesos Q = new Bang( new Ask(new XltC(b,200),new Next(new Tell(new XeqC(a,50))) ) );


    Procesos reaction = new Par(P,Q);
    //add process to planner of execution

    testChoice.addProce(reaction);

    //file that adds the constraint of the environment.
      Ambient.getAmbient().readerVarsXml("TestEjer1.xml");
    // time unit of execution
    testChoice.setTimeUnit(10);


    //Planner run
    testChoice.run();
    }
}
