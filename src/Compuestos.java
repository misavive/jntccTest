import org.jacop.constraints.*;
import org.jacop.core.IntVar;
import utccEnums.*;
import utcclang.*;


/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Date: 12/11/12
* Time: 9:05
*
*/
    public  class Compuestos {


        public static void main(String[] args) {

            //the planner.
            Planner testCompuesto = new Planner();

            //Store output file name
            Store.setFilename("Compuestos");

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

            Procesos reaction = new Bang(new Choice(new AskChoice(new XgteqC(c,1),Z),
                                                    new AskChoice(new And(new XgteqC(a,1),new XlteqC(b,2)),Q) )  ) ;

            //add process to planner of execution
            PrimitiveConstraint c2 =  new And( Ar.expre(new XgteqC(a,1),new XlteqC(b,2),new XlteqC(b,2),new XlteqC(b,2) )) ;

            testCompuesto.addProce(reaction);

            //reading file that adds  constraint of environment.
            Ambient.getAmbient().readerVarsXml("Compuestos.xml");
            // time unit of execution
            testCompuesto.setTimeUnit(2000);
            //Planner run
            testCompuesto.run();
        }
    }
