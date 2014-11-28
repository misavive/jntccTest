
/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Master Student University Javeriana Cali.
*
*/


import org.jacop.constraints.*;
import org.jacop.core.IntVar;
import utcclang.*;
import utccEnums.*;


public  class Compuesto {

    public static void main(String[] args) {

        //the planner.
        Planner jntccCompuesto = new Planner();

        //Store output file name
        utcclang.Store.setFilename("Compuesto.txt");

        //the variables
        //Note: the declaration of variables can not fixed range, for utilization whith Change.
        //      the variables for increment or decrement can not exceed the range initially declared

        // the instruction change modify the value initial of variables in next unit time.

        IntVar x = utcclang.Store.getStore().creavarsRetor("a",-2147483648,2147483647);
        IntVar y = utcclang.Store.getStore().creavarsRetor("b",-2147483648,2147483647);



        //Declaration of Process.
        Procesos P=new Tell(new XeqC(x,5));
        Procesos Q=new Tell(new XeqC(y,5));
        Procesos Z=new Par(P,Q);   Ar.expre(new XeqC(y,5),new XeqC(x,5),new XeqC(x,5));
        //add process to planner of execution

        jntccCompuesto.addProce(Z);

        // file that adds the constraint of the environment. *** These will be added after the first unit. ***
        Ambient.getAmbient().readerVarsXml("Compuesto.xml");

        // time unit of execution
        jntccCompuesto.setTimeUnit(10);
        //Planner run
        jntccCompuesto.run();
    }
}