import org.jacop.constraints.And;
import org.jacop.constraints.PrimitiveConstraint;

/**
 * Created by misaelviveroscastro on 8/05/14.
 */

public class AndM {


    public And AndM(PrimitiveConstraint... cons) {
        PrimitiveConstraint[] pc = new PrimitiveConstraint[cons.length];
        //PrimitiveConstraint c = (PrimitiveConstraint) cons;

        for (int x = 0; x > cons.length;x++ ) {
            PrimitiveConstraint c1 = (PrimitiveConstraint) cons[x];
            pc[x]= c1;
        }

        return new And(pc) ;
    }

}
