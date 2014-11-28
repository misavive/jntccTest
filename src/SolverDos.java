import org.jacop.constraints.Sequence;
import org.jacop.core.IntVar;
import org.jacop.core.IntervalDomain;
import org.jacop.core.Store;
import org.jacop.search.*;


/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Master Student University Javeriana Cali.
*
*/


public  class SolverDos {

    public static void main(String[] args) {

        // Creating constraint store .
        // This object contains information about all the constraints and variables.
        Store store = new Store();

        IntVar[] var = new IntVar[10];
        for (int i=0; i<var.length; i++)
            var[i] = new IntVar(store, "v"+i, 0, 9);

        store.imposeDecomposition(new Sequence(var, //variable list new IntervalDomain(1,1),
                                  new IntervalDomain(1,4), //set of values
                                                     10, // q, sequence length
                                                     1, // min
                                                     5 //max
                                  ));

        Search<IntVar> search = new DepthFirstSearch<IntVar>();
        SelectChoicePoint<IntVar> select =
                new InputOrderSelect<IntVar>(store, var,
                        new IndomainMin<IntVar>());
        boolean result  = search.labeling(store, select);

        if ( result ){
           search.printAllSolutions();
        }
    }
}