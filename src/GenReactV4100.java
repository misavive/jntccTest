
/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Master Student University Javeriana Cali.
*
*/

import org.jacop.constraints.And;
import org.jacop.constraints.XeqC;
import org.jacop.constraints.XgteqC;
import org.jacop.core.IntVar;
import utccEnums.Ar;
import utccEnums.Operation;
import utcclang.*;

public  class GenReactV4100 {


    public static void main(String[] args) {

            //the planner.
              Planner jntccGenReactV4 = new Planner();

          //Store output file name
          Store.setFilename("GenReactV4100.txt");

          //the variables
          //Note: the declaration of variables can not fixed range, for utilization whit Change.
          //      the variables the increment or decrement can not exceed the range initially declared

          // the instruction change modify the value initial of variables in next unit time.

            IntVar a = Store.getStore().creavarsRetor("a",1000,2000);
             IntVar b = Store.getStore().creavarsRetor("b",1000,2000);
             IntVar c = Store.getStore().creavarsRetor("c",0,300);
             IntVar d = Store.getStore().creavarsRetor("d",0,300);
             IntVar e = Store.getStore().creavarsRetor("e",0,300);
             IntVar f = Store.getStore().creavarsRetor("f",0,300);
             IntVar g = Store.getStore().creavarsRetor("g",0,300);
             IntVar h = Store.getStore().creavarsRetor("h",0,300);
             IntVar i = Store.getStore().creavarsRetor("i",0,300);
             IntVar j = Store.getStore().creavarsRetor("j",0,300);
             IntVar k = Store.getStore().creavarsRetor("k",0,300);
             IntVar l = Store.getStore().creavarsRetor("l",0,300);
             IntVar m = Store.getStore().creavarsRetor("m",0,300);



          //Declaration of Process.
              Procesos P0 =      new Par(  new Change(h, Operation._DECRE,7),
                new Change(m, Operation._DECRE,1),
                 new Change(d, Operation._INCRE,10),
                 new Change(e, Operation._INCRE,3) ) ;

              Procesos P1 =      new Par(  new Change(d, Operation._DECRE,8),
                new Change(e, Operation._DECRE,1),
                new Change(h, Operation._DECRE,8),
                 new Change(l, Operation._INCRE,7) ) ;

              Procesos P2 =      new Par(  new Change(h, Operation._DECRE,8),
                new Change(k, Operation._DECRE,5),
                 new Change(d, Operation._INCRE,9),
                 new Change(e, Operation._INCRE,3) ) ;

              Procesos P3 =      new Par(  new Change(j, Operation._DECRE,3),
                new Change(m, Operation._DECRE,4),
                 new Change(d, Operation._INCRE,1),
                 new Change(e, Operation._INCRE,2) ) ;

              Procesos P4 =      new Par(  new Change(d, Operation._DECRE,8),
                new Change(e, Operation._DECRE,6),
                new Change(j, Operation._DECRE,6),
                 new Change(k, Operation._INCRE,3) ) ;

              Procesos P5 =      new Par(  new Change(d, Operation._DECRE,1),
                 new Change(e, Operation._INCRE,3),
                 new Change(j, Operation._INCRE,4),
                 new Change(l, Operation._INCRE,6) ) ;

              Procesos P6 =      new Par(  new Change(d, Operation._DECRE,2),
                 new Change(e, Operation._INCRE,6),
                 new Change(i, Operation._INCRE,5),
                 new Change(l, Operation._INCRE,6) ) ;

              Procesos P7 =      new Par(  new Change(d, Operation._DECRE,1),
                new Change(e, Operation._DECRE,8),
                new Change(i, Operation._DECRE,5),
                 new Change(k, Operation._INCRE,10) ) ;

              Procesos P8 =      new Par(  new Change(d, Operation._DECRE,7),
                 new Change(e, Operation._INCRE,4),
                 new Change(i, Operation._INCRE,4),
                 new Change(m, Operation._INCRE,7) ) ;

              Procesos P9 =      new Par(  new Change(i, Operation._DECRE,6),
                new Change(m, Operation._DECRE,5),
                 new Change(d, Operation._INCRE,7),
                 new Change(g, Operation._INCRE,5) ) ;

              Procesos P10 =      new Par(  new Change(d, Operation._DECRE,5),
                new Change(g, Operation._DECRE,6),
                new Change(i, Operation._DECRE,3),
                 new Change(k, Operation._INCRE,5) ) ;

              Procesos P11 =      new Par(  new Change(d, Operation._DECRE,4),
                new Change(g, Operation._DECRE,2),
                new Change(i, Operation._DECRE,6),
                 new Change(l, Operation._INCRE,1) ) ;

              Procesos P12 =      new Par(  new Change(d, Operation._DECRE,3),
                new Change(g, Operation._DECRE,3),
                new Change(j, Operation._DECRE,1),
                 new Change(m, Operation._INCRE,6) ) ;

              Procesos P13 =      new Par(  new Change(j, Operation._DECRE,2),
                new Change(k, Operation._DECRE,3),
                 new Change(d, Operation._INCRE,10),
                 new Change(g, Operation._INCRE,8) ) ;

              Procesos P14 =      new Par(  new Change(d, Operation._DECRE,6),
                 new Change(g, Operation._INCRE,4),
                 new Change(j, Operation._INCRE,7),
                 new Change(l, Operation._INCRE,2) ) ;

              Procesos P15 =      new Par(  new Change(h, Operation._DECRE,4),
                new Change(l, Operation._DECRE,8),
                 new Change(d, Operation._INCRE,7),
                 new Change(g, Operation._INCRE,5) ) ;

              Procesos P16 =      new Par(  new Change(d, Operation._DECRE,8),
                new Change(g, Operation._DECRE,2),
                new Change(h, Operation._DECRE,6),
                 new Change(m, Operation._INCRE,6) ) ;

              Procesos P17 =      new Par(  new Change(d, Operation._DECRE,5),
                new Change(g, Operation._DECRE,7),
                new Change(h, Operation._DECRE,7),
                 new Change(k, Operation._INCRE,2) ) ;

              Procesos P18 =      new Par(  new Change(d, Operation._DECRE,6),
                new Change(h, Operation._DECRE,1),
                new Change(j, Operation._DECRE,8),
                 new Change(m, Operation._INCRE,3) ) ;

              Procesos P19 =      new Par(  new Change(j, Operation._DECRE,4),
                new Change(k, Operation._DECRE,4),
                 new Change(d, Operation._INCRE,8),
                 new Change(h, Operation._INCRE,4) ) ;

              Procesos P20 =      new Par(  new Change(j, Operation._DECRE,5),
                new Change(l, Operation._DECRE,2),
                 new Change(d, Operation._INCRE,8),
                 new Change(h, Operation._INCRE,10) ) ;

              Procesos P21 =      new Par(  new Change(i, Operation._DECRE,4),
                new Change(m, Operation._DECRE,8),
                 new Change(d, Operation._INCRE,8),
                 new Change(h, Operation._INCRE,4) ) ;

              Procesos P22 =      new Par(  new Change(d, Operation._DECRE,7),
                 new Change(h, Operation._INCRE,5),
                 new Change(i, Operation._INCRE,1),
                 new Change(k, Operation._INCRE,2) ) ;

              Procesos P23 =      new Par(  new Change(d, Operation._DECRE,4),
                new Change(h, Operation._DECRE,7),
                new Change(i, Operation._DECRE,1),
                 new Change(l, Operation._INCRE,7) ) ;

              Procesos P24 =      new Par(  new Change(i, Operation._DECRE,5),
                new Change(k, Operation._DECRE,6),
                 new Change(d, Operation._INCRE,1),
                 new Change(f, Operation._INCRE,4) ) ;

              Procesos P25 =      new Par(  new Change(d, Operation._DECRE,2),
                new Change(f, Operation._DECRE,4),
                new Change(i, Operation._DECRE,2),
                 new Change(l, Operation._INCRE,2) ) ;

              Procesos P26 =      new Par(  new Change(d, Operation._DECRE,8),
                new Change(f, Operation._DECRE,3),
                new Change(i, Operation._DECRE,8),
                 new Change(m, Operation._INCRE,9) ) ;

              Procesos P27 =      new Par(  new Change(d, Operation._DECRE,4),
                 new Change(f, Operation._INCRE,10),
                 new Change(h, Operation._INCRE,5),
                 new Change(l, Operation._INCRE,1) ) ;

              Procesos P28 =      new Par(  new Change(d, Operation._DECRE,8),
                 new Change(f, Operation._INCRE,7),
                 new Change(h, Operation._INCRE,8),
                 new Change(m, Operation._INCRE,7) ) ;

              Procesos P29 =      new Par(  new Change(h, Operation._DECRE,2),
                new Change(k, Operation._DECRE,6),
                 new Change(d, Operation._INCRE,4),
                 new Change(f, Operation._INCRE,4) ) ;

              Procesos P30 =      new Par(  new Change(j, Operation._DECRE,7),
                new Change(l, Operation._DECRE,3),
                 new Change(d, Operation._INCRE,2),
                 new Change(f, Operation._INCRE,1) ) ;

              Procesos P31 =      new Par(  new Change(d, Operation._DECRE,4),
                 new Change(f, Operation._INCRE,4),
                 new Change(j, Operation._INCRE,9),
                 new Change(m, Operation._INCRE,9) ) ;

              Procesos P32 =      new Par(  new Change(d, Operation._DECRE,4),
                new Change(f, Operation._DECRE,7),
                new Change(j, Operation._DECRE,8),
                 new Change(k, Operation._INCRE,1) ) ;

              Procesos P33 =      new Par(  new Change(j, Operation._DECRE,6),
                new Change(l, Operation._DECRE,6),
                 new Change(b, Operation._INCRE,9),
                 new Change(h, Operation._INCRE,9) ) ;

              Procesos P34 =      new Par(  new Change(b, Operation._DECRE,2),
                new Change(h, Operation._DECRE,5),
                new Change(j, Operation._DECRE,7),
                 new Change(k, Operation._INCRE,9) ) ;

              Procesos P35 =      new Par(  new Change(j, Operation._DECRE,5),
                new Change(m, Operation._DECRE,7),
                 new Change(b, Operation._INCRE,10),
                 new Change(h, Operation._INCRE,1) ) ;

              Procesos P36 =      new Par(  new Change(b, Operation._DECRE,3),
                 new Change(h, Operation._INCRE,9),
                 new Change(i, Operation._INCRE,9),
                 new Change(m, Operation._INCRE,10) ) ;

              Procesos P37 =      new Par(  new Change(i, Operation._DECRE,4),
                new Change(l, Operation._DECRE,5),
                 new Change(b, Operation._INCRE,6),
                 new Change(h, Operation._INCRE,5) ) ;

              Procesos P38 =      new Par(  new Change(b, Operation._DECRE,1),
                new Change(h, Operation._DECRE,4),
                new Change(i, Operation._DECRE,6),
                 new Change(k, Operation._INCRE,4) ) ;

              Procesos P39 =      new Par(  new Change(b, Operation._DECRE,2),
                 new Change(f, Operation._INCRE,8),
                 new Change(h, Operation._INCRE,9),
                 new Change(m, Operation._INCRE,2) ) ;

              Procesos P40 =      new Par(  new Change(b, Operation._DECRE,7),
                 new Change(f, Operation._INCRE,5),
                 new Change(h, Operation._INCRE,3),
                 new Change(l, Operation._INCRE,5) ) ;

              Procesos P41 =      new Par(  new Change(b, Operation._DECRE,7),
                new Change(f, Operation._DECRE,8),
                new Change(h, Operation._DECRE,2),
                 new Change(k, Operation._INCRE,7) ) ;

              Procesos P42 =      new Par(  new Change(b, Operation._DECRE,1),
                new Change(f, Operation._DECRE,6),
                new Change(j, Operation._DECRE,1),
                 new Change(k, Operation._INCRE,6) ) ;

              Procesos P43 =      new Par(  new Change(b, Operation._DECRE,6),
                new Change(f, Operation._DECRE,1),
                new Change(j, Operation._DECRE,3),
                 new Change(l, Operation._INCRE,3) ) ;

              Procesos P44 =      new Par(  new Change(b, Operation._DECRE,4),
                 new Change(f, Operation._INCRE,5),
                 new Change(j, Operation._INCRE,5),
                 new Change(m, Operation._INCRE,4) ) ;

              Procesos P45 =      new Par(  new Change(b, Operation._DECRE,2),
                 new Change(f, Operation._INCRE,8),
                 new Change(i, Operation._INCRE,2),
                 new Change(k, Operation._INCRE,10) ) ;

              Procesos P46 =      new Par(  new Change(i, Operation._DECRE,1),
                new Change(m, Operation._DECRE,1),
                 new Change(b, Operation._INCRE,4),
                 new Change(f, Operation._INCRE,2) ) ;

              Procesos P47 =      new Par(  new Change(i, Operation._DECRE,7),
                new Change(l, Operation._DECRE,1),
                 new Change(b, Operation._INCRE,8),
                 new Change(f, Operation._INCRE,10) ) ;

              Procesos P48 =      new Par(  new Change(i, Operation._DECRE,1),
                new Change(m, Operation._DECRE,7),
                 new Change(b, Operation._INCRE,1),
                 new Change(e, Operation._INCRE,10) ) ;

              Procesos P49 =      new Par(  new Change(i, Operation._DECRE,5),
                new Change(k, Operation._DECRE,4),
                 new Change(b, Operation._INCRE,3),
                 new Change(e, Operation._INCRE,10) ) ;

              Procesos P50 =      new Par(  new Change(b, Operation._DECRE,8),
                new Change(e, Operation._DECRE,3),
                new Change(i, Operation._DECRE,8),
                 new Change(l, Operation._INCRE,1) ) ;

              Procesos P51 =      new Par(  new Change(h, Operation._DECRE,8),
                new Change(m, Operation._DECRE,3),
                 new Change(b, Operation._INCRE,4),
                 new Change(e, Operation._INCRE,7) ) ;

              Procesos P52 =      new Par(  new Change(b, Operation._DECRE,6),
                new Change(e, Operation._DECRE,6),
                new Change(h, Operation._DECRE,8),
                 new Change(l, Operation._INCRE,7) ) ;

              Procesos P53 =      new Par(  new Change(b, Operation._DECRE,3),
                new Change(e, Operation._DECRE,6),
                new Change(h, Operation._DECRE,8),
                 new Change(k, Operation._INCRE,2) ) ;

              Procesos P54 =      new Par(  new Change(b, Operation._DECRE,4),
                 new Change(e, Operation._INCRE,1),
                 new Change(j, Operation._INCRE,4),
                 new Change(l, Operation._INCRE,1) ) ;

              Procesos P55 =      new Par(  new Change(b, Operation._DECRE,4),
                 new Change(e, Operation._INCRE,3),
                 new Change(j, Operation._INCRE,5),
                 new Change(k, Operation._INCRE,3) ) ;

              Procesos P56 =      new Par(  new Change(b, Operation._DECRE,7),
                 new Change(e, Operation._INCRE,5),
                 new Change(j, Operation._INCRE,5),
                 new Change(m, Operation._INCRE,7) ) ;

              Procesos P57 =      new Par(  new Change(h, Operation._DECRE,7),
                new Change(m, Operation._DECRE,6),
                 new Change(b, Operation._INCRE,5),
                 new Change(g, Operation._INCRE,2) ) ;

              Procesos P58 =      new Par(  new Change(b, Operation._DECRE,4),
                new Change(g, Operation._DECRE,7),
                new Change(h, Operation._DECRE,3),
                 new Change(l, Operation._INCRE,5) ) ;

              Procesos P59 =      new Par(  new Change(b, Operation._DECRE,3),
                new Change(g, Operation._DECRE,5),
                new Change(h, Operation._DECRE,4),
                 new Change(k, Operation._INCRE,4) ) ;

              Procesos P60 =      new Par(  new Change(j, Operation._DECRE,8),
                new Change(k, Operation._DECRE,6),
                 new Change(b, Operation._INCRE,1),
                 new Change(g, Operation._INCRE,4) ) ;

              Procesos P61 =      new Par(  new Change(b, Operation._DECRE,7),
                 new Change(g, Operation._INCRE,4),
                 new Change(j, Operation._INCRE,7),
                 new Change(m, Operation._INCRE,4) ) ;

              Procesos P62 =      new Par(  new Change(b, Operation._DECRE,1),
                 new Change(g, Operation._INCRE,9),
                 new Change(j, Operation._INCRE,2),
                 new Change(l, Operation._INCRE,10) ) ;

              Procesos P63 =      new Par(  new Change(i, Operation._DECRE,3),
                new Change(k, Operation._DECRE,4),
                 new Change(b, Operation._INCRE,6),
                 new Change(g, Operation._INCRE,9) ) ;

              Procesos P64 =      new Par(  new Change(b, Operation._DECRE,3),
                 new Change(g, Operation._INCRE,2),
                 new Change(i, Operation._INCRE,10),
                 new Change(m, Operation._INCRE,2) ) ;

              Procesos P65 =      new Par(  new Change(b, Operation._DECRE,1),
                new Change(g, Operation._DECRE,2),
                new Change(i, Operation._DECRE,1),
                 new Change(l, Operation._INCRE,6) ) ;

              Procesos P66 =      new Par(  new Change(c, Operation._DECRE,7),
                 new Change(h, Operation._INCRE,3),
                 new Change(j, Operation._INCRE,3),
                 new Change(m, Operation._INCRE,2) ) ;

              Procesos P67 =      new Par(  new Change(j, Operation._DECRE,2),
                new Change(k, Operation._DECRE,3),
                 new Change(c, Operation._INCRE,4),
                 new Change(h, Operation._INCRE,5) ) ;

              Procesos P68 =      new Par(  new Change(c, Operation._DECRE,8),
                 new Change(h, Operation._INCRE,10),
                 new Change(j, Operation._INCRE,8),
                 new Change(l, Operation._INCRE,7) ) ;

              Procesos P69 =      new Par(  new Change(i, Operation._DECRE,7),
                new Change(k, Operation._DECRE,7),
                 new Change(c, Operation._INCRE,3),
                 new Change(h, Operation._INCRE,10) ) ;

              Procesos P70 =      new Par(  new Change(i, Operation._DECRE,5),
                new Change(l, Operation._DECRE,7),
                 new Change(c, Operation._INCRE,3),
                 new Change(h, Operation._INCRE,5) ) ;

              Procesos P71 =      new Par(  new Change(i, Operation._DECRE,4),
                new Change(m, Operation._DECRE,4),
                 new Change(c, Operation._INCRE,3),
                 new Change(h, Operation._INCRE,10) ) ;

              Procesos P72 =      new Par(  new Change(i, Operation._DECRE,5),
                new Change(l, Operation._DECRE,2),
                 new Change(c, Operation._INCRE,4),
                 new Change(f, Operation._INCRE,2) ) ;

              Procesos P73 =      new Par(  new Change(c, Operation._DECRE,8),
                 new Change(f, Operation._INCRE,10),
                 new Change(i, Operation._INCRE,5),
                 new Change(m, Operation._INCRE,5) ) ;

              Procesos P74 =      new Par(  new Change(c, Operation._DECRE,7),
                new Change(f, Operation._DECRE,7),
                new Change(i, Operation._DECRE,2),
                 new Change(k, Operation._INCRE,10) ) ;

              Procesos P75 =      new Par(  new Change(j, Operation._DECRE,4),
                new Change(k, Operation._DECRE,4),
                 new Change(c, Operation._INCRE,4),
                 new Change(f, Operation._INCRE,7) ) ;

              Procesos P76 =      new Par(  new Change(j, Operation._DECRE,2),
                new Change(m, Operation._DECRE,5),
                 new Change(c, Operation._INCRE,5),
                 new Change(f, Operation._INCRE,10) ) ;

              Procesos P77 =      new Par(  new Change(j, Operation._DECRE,1),
                new Change(l, Operation._DECRE,4),
                 new Change(c, Operation._INCRE,4),
                 new Change(f, Operation._INCRE,6) ) ;

              Procesos P78 =      new Par(  new Change(h, Operation._DECRE,5),
                new Change(l, Operation._DECRE,1),
                 new Change(c, Operation._INCRE,8),
                 new Change(f, Operation._INCRE,2) ) ;

              Procesos P79 =      new Par(  new Change(c, Operation._DECRE,5),
                new Change(f, Operation._DECRE,8),
                new Change(h, Operation._DECRE,1),
                 new Change(k, Operation._INCRE,3) ) ;

              Procesos P80 =      new Par(  new Change(h, Operation._DECRE,5),
                new Change(m, Operation._DECRE,6),
                 new Change(c, Operation._INCRE,4),
                 new Change(f, Operation._INCRE,5) ) ;

              Procesos P81 =      new Par(  new Change(j, Operation._DECRE,5),
                new Change(k, Operation._DECRE,3),
                 new Change(c, Operation._INCRE,7),
                 new Change(e, Operation._INCRE,7) ) ;

              Procesos P82 =      new Par(  new Change(c, Operation._DECRE,4),
                 new Change(e, Operation._INCRE,7),
                 new Change(j, Operation._INCRE,8),
                 new Change(l, Operation._INCRE,7) ) ;

              Procesos P83 =      new Par(  new Change(c, Operation._DECRE,6),
                new Change(e, Operation._DECRE,5),
                new Change(j, Operation._DECRE,4),
                 new Change(m, Operation._INCRE,2) ) ;

              Procesos P84 =      new Par(  new Change(i, Operation._DECRE,8),
                new Change(m, Operation._DECRE,8),
                 new Change(c, Operation._INCRE,8),
                 new Change(e, Operation._INCRE,10) ) ;

              Procesos P85 =      new Par(  new Change(c, Operation._DECRE,7),
                 new Change(e, Operation._INCRE,8),
                 new Change(i, Operation._INCRE,8),
                 new Change(l, Operation._INCRE,9) ) ;

              Procesos P86 =      new Par(  new Change(i, Operation._DECRE,8),
                new Change(k, Operation._DECRE,7),
                 new Change(c, Operation._INCRE,4),
                 new Change(e, Operation._INCRE,4) ) ;

              Procesos P87 =      new Par(  new Change(c, Operation._DECRE,8),
                 new Change(e, Operation._INCRE,9),
                 new Change(h, Operation._INCRE,10),
                 new Change(k, Operation._INCRE,6) ) ;

              Procesos P88 =      new Par(  new Change(c, Operation._DECRE,6),
                new Change(e, Operation._DECRE,3),
                new Change(h, Operation._DECRE,7),
                 new Change(l, Operation._INCRE,6) ) ;

              Procesos P89 =      new Par(  new Change(h, Operation._DECRE,2),
                new Change(m, Operation._DECRE,4),
                 new Change(c, Operation._INCRE,6),
                 new Change(e, Operation._INCRE,4) ) ;

              Procesos P90 =      new Par(  new Change(c, Operation._DECRE,3),
                new Change(g, Operation._DECRE,2),
                new Change(h, Operation._DECRE,6),
                 new Change(k, Operation._INCRE,6) ) ;

              Procesos P91 =      new Par(  new Change(c, Operation._DECRE,6),
                new Change(g, Operation._DECRE,8),
                new Change(h, Operation._DECRE,6),
                 new Change(m, Operation._INCRE,9) ) ;

              Procesos P92 =      new Par(  new Change(c, Operation._DECRE,6),
                new Change(g, Operation._DECRE,5),
                new Change(h, Operation._DECRE,2),
                 new Change(l, Operation._INCRE,7) ) ;

              Procesos P93 =      new Par(  new Change(c, Operation._DECRE,2),
                new Change(g, Operation._DECRE,4),
                new Change(j, Operation._DECRE,1),
                 new Change(l, Operation._INCRE,1) ) ;

              Procesos P94 =      new Par(  new Change(c, Operation._DECRE,5),
                 new Change(g, Operation._INCRE,9),
                 new Change(j, Operation._INCRE,1),
                 new Change(m, Operation._INCRE,5) ) ;

              Procesos P95 =      new Par(  new Change(c, Operation._DECRE,3),
                new Change(g, Operation._DECRE,8),
                new Change(j, Operation._DECRE,3),
                 new Change(k, Operation._INCRE,7) ) ;

              Procesos P96 =      new Par(  new Change(c, Operation._DECRE,4),
                new Change(g, Operation._DECRE,4),
                new Change(i, Operation._DECRE,2),
                 new Change(l, Operation._INCRE,5) ) ;

              Procesos P97 =      new Par(  new Change(i, Operation._DECRE,7),
                new Change(k, Operation._DECRE,1),
                 new Change(c, Operation._INCRE,10),
                 new Change(g, Operation._INCRE,8) ) ;

              Procesos P98 =      new Par(  new Change(c, Operation._DECRE,4),
                 new Change(g, Operation._INCRE,5),
                 new Change(i, Operation._INCRE,6),
                 new Change(m, Operation._INCRE,7) ) ;

              Procesos P99 =      new Par(  new Change(a, Operation._DECRE,1),
                 new Change(g, Operation._INCRE,3),
                 new Change(h, Operation._INCRE,4),
                 new Change(l, Operation._INCRE,3) ) ;

              Procesos P100 =      new Par(  new Change(h, Operation._DECRE,2),
                new Change(k, Operation._DECRE,6),
                 new Change(a, Operation._INCRE,3),
                 new Change(g, Operation._INCRE,10) ) ;



        Procesos P132 =      new Par(new Tell(new XeqC(a,220)),new Tell(new XeqC(b,220)),new Tell(new XeqC(c,220)),new Tell(new XeqC(d,220)),
                new Tell(new XeqC(e,220)),new Tell(new XeqC(f,220)),new Tell(new XeqC(g,220)),new Tell(new XeqC(h,220)),
                new Tell(new XeqC(i,220)),new Tell(new XeqC(j,220)),new Tell(new XeqC(k,220)),new Tell(new XeqC(l,220)),
                new Tell(new XeqC(m,220))) ;



            Procesos reaction = new Bang(  new Choice(   new AskChoice(new And(Ar.expre(  new XgteqC(h,7),
               new XgteqC(m,1)) ) ,P0)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,8),
               new XgteqC(e,1),
               new XgteqC(h,8)) ) ,P1)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,8),
               new XgteqC(k,5)) ) ,P2)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,3),
               new XgteqC(m,4)) ) ,P3)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,8),
               new XgteqC(e,6),
               new XgteqC(j,6)) ) ,P4)   ,
             new AskChoice(  new XgteqC(d,1),P5)   ,
             new AskChoice(  new XgteqC(d,2),P6)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,1),
               new XgteqC(e,8),
               new XgteqC(i,5)) ) ,P7)   ,
             new AskChoice(  new XgteqC(d,7),P8)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,6),
               new XgteqC(m,5)) ) ,P9)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,5),
               new XgteqC(g,6),
               new XgteqC(i,3)) ) ,P10)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,4),
               new XgteqC(g,2),
               new XgteqC(i,6)) ) ,P11)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,3),
               new XgteqC(g,3),
               new XgteqC(j,1)) ) ,P12)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,2),
               new XgteqC(k,3)) ) ,P13)   ,
             new AskChoice(  new XgteqC(d,6),P14)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,4),
               new XgteqC(l,8)) ) ,P15)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,8),
               new XgteqC(g,2),
               new XgteqC(h,6)) ) ,P16)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,5),
               new XgteqC(g,7),
               new XgteqC(h,7)) ) ,P17)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,6),
               new XgteqC(h,1),
               new XgteqC(j,8)) ) ,P18)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,4),
               new XgteqC(k,4)) ) ,P19)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,5),
               new XgteqC(l,2)) ) ,P20)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,4),
               new XgteqC(m,8)) ) ,P21)   ,
             new AskChoice(  new XgteqC(d,7),P22)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,4),
               new XgteqC(h,7),
               new XgteqC(i,1)) ) ,P23)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,5),
               new XgteqC(k,6)) ) ,P24)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,2),
               new XgteqC(f,4),
               new XgteqC(i,2)) ) ,P25)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,8),
               new XgteqC(f,3),
               new XgteqC(i,8)) ) ,P26)   ,
             new AskChoice(  new XgteqC(d,4),P27)   ,
             new AskChoice(  new XgteqC(d,8),P28)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,2),
               new XgteqC(k,6)) ) ,P29)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,7),
               new XgteqC(l,3)) ) ,P30)   ,
             new AskChoice(  new XgteqC(d,4),P31)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(d,4),
               new XgteqC(f,7),
               new XgteqC(j,8)) ) ,P32)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,6),
               new XgteqC(l,6)) ) ,P33)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,2),
               new XgteqC(h,5),
               new XgteqC(j,7)) ) ,P34)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,5),
               new XgteqC(m,7)) ) ,P35)   ,
             new AskChoice(  new XgteqC(b,3),P36)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,4),
               new XgteqC(l,5)) ) ,P37)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,1),
               new XgteqC(h,4),
               new XgteqC(i,6)) ) ,P38)   ,
             new AskChoice(  new XgteqC(b,2),P39)   ,
             new AskChoice(  new XgteqC(b,7),P40)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,7),
               new XgteqC(f,8),
               new XgteqC(h,2)) ) ,P41)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,1),
               new XgteqC(f,6),
               new XgteqC(j,1)) ) ,P42)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,6),
               new XgteqC(f,1),
               new XgteqC(j,3)) ) ,P43)   ,
             new AskChoice(  new XgteqC(b,4),P44)   ,
             new AskChoice(  new XgteqC(b,2),P45)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,1),
               new XgteqC(m,1)) ) ,P46)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,7),
               new XgteqC(l,1)) ) ,P47)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,1),
               new XgteqC(m,7)) ) ,P48)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,5),
               new XgteqC(k,4)) ) ,P49)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,8),
               new XgteqC(e,3),
               new XgteqC(i,8)) ) ,P50)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,8),
               new XgteqC(m,3)) ) ,P51)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,6),
               new XgteqC(e,6),
               new XgteqC(h,8)) ) ,P52)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,3),
               new XgteqC(e,6),
               new XgteqC(h,8)) ) ,P53)   ,
             new AskChoice(  new XgteqC(b,4),P54)   ,
             new AskChoice(  new XgteqC(b,4),P55)   ,
             new AskChoice(  new XgteqC(b,7),P56)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,7),
               new XgteqC(m,6)) ) ,P57)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,4),
               new XgteqC(g,7),
               new XgteqC(h,3)) ) ,P58)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,3),
               new XgteqC(g,5),
               new XgteqC(h,4)) ) ,P59)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,8),
               new XgteqC(k,6)) ) ,P60)   ,
             new AskChoice(  new XgteqC(b,7),P61)   ,
             new AskChoice(  new XgteqC(b,1),P62)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,3),
               new XgteqC(k,4)) ) ,P63)   ,
             new AskChoice(  new XgteqC(b,3),P64)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(b,1),
               new XgteqC(g,2),
               new XgteqC(i,1)) ) ,P65)   ,
             new AskChoice(  new XgteqC(c,7),P66)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,2),
               new XgteqC(k,3)) ) ,P67)   ,
             new AskChoice(  new XgteqC(c,8),P68)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,7),
               new XgteqC(k,7)) ) ,P69)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,5),
               new XgteqC(l,7)) ) ,P70)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,4),
               new XgteqC(m,4)) ) ,P71)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,5),
               new XgteqC(l,2)) ) ,P72)   ,
             new AskChoice(  new XgteqC(c,8),P73)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,7),
               new XgteqC(f,7),
               new XgteqC(i,2)) ) ,P74)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,4),
               new XgteqC(k,4)) ) ,P75)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,2),
               new XgteqC(m,5)) ) ,P76)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,1),
               new XgteqC(l,4)) ) ,P77)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,5),
               new XgteqC(l,1)) ) ,P78)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,5),
               new XgteqC(f,8),
               new XgteqC(h,1)) ) ,P79)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,5),
               new XgteqC(m,6)) ) ,P80)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(j,5),
               new XgteqC(k,3)) ) ,P81)   ,
             new AskChoice(  new XgteqC(c,4),P82)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,6),
               new XgteqC(e,5),
               new XgteqC(j,4)) ) ,P83)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,8),
               new XgteqC(m,8)) ) ,P84)   ,
             new AskChoice(  new XgteqC(c,7),P85)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,8),
               new XgteqC(k,7)) ) ,P86)   ,
             new AskChoice(  new XgteqC(c,8),P87)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,6),
               new XgteqC(e,3),
               new XgteqC(h,7)) ) ,P88)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,2),
               new XgteqC(m,4)) ) ,P89)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,3),
               new XgteqC(g,2),
               new XgteqC(h,6)) ) ,P90)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,6),
               new XgteqC(g,8),
               new XgteqC(h,6)) ) ,P91)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,6),
               new XgteqC(g,5),
               new XgteqC(h,2)) ) ,P92)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,2),
               new XgteqC(g,4),
               new XgteqC(j,1)) ) ,P93)   ,
             new AskChoice(  new XgteqC(c,5),P94)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,3),
               new XgteqC(g,8),
               new XgteqC(j,3)) ) ,P95)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(c,4),
               new XgteqC(g,4),
               new XgteqC(i,2)) ) ,P96)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(i,7),
               new XgteqC(k,1)) ) ,P97)   ,
             new AskChoice(  new XgteqC(c,4),P98)   ,
             new AskChoice(  new XgteqC(a,1),P99)   ,
             new AskChoice(new And(Ar.expre(  new XgteqC(h,2),
               new XgteqC(k,6)) ) ,P100)  )    );


        Procesos P133 = new Par(P132,reaction);

          //add process to planner of execution

          jntccGenReactV4.addProce(P133);

          // file that adds the constraint of the environment. *** These will be added after the first unit. ***
          Ambient.getAmbient().readerVarsXml("GenReactV4100.xml");

          // time unit of execution
          jntccGenReactV4.setTimeUnit(100000);
          //Planner run
          jntccGenReactV4.run();
    }
}