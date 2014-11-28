import org.jacop.constraints.Constraint;
import org.jacop.core.IntVar;
import utcclang.Ambient;
import utcclang.AmbientC;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Date: 12/11/12
* Time: 9:05
*
*/
public  class TestConst {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Ambient ambiente = new Ambient();
        String name = "JaCoP.constraints.XmulCeqZ",par1 = "x",par2="y",par3="z";
        Integer const1 = 10,const2=5,const3=8;
         Integer unit = 1;
        AmbientC ambc = new AmbientC();
        IntVar y = new IntVar();
        y.id = par1;
        ambiente.addEnviroment(name,par1,const1,par2,unit);
        Constraint x = ambiente.converConstrain(name,par1,const1,par2);
        ambc.addAmbientCon(par1,const1,par2,unit,x);

        IntVar varConverX = new IntVar();IntVar varConverY = new IntVar();  varConverX.id = par1; varConverY.id = par2;
        Class<?> clasCon = Class.forName(name);
        System.out.println(clasCon.toString());
        Constructor<?> constru2 = clasCon.getDeclaredConstructor(new Class<?>[] {org.jacop.core.IntVar.class,int.class,org.jacop.core.IntVar.class});
        Constraint c = (Constraint) constru2.newInstance(varConverX,const1,varConverY);
        System.out.println(constru2.toString());
        System.out.println(c.id()+ " "+c.numberArgs);
        //System.out.println(x.id());



    }
}
