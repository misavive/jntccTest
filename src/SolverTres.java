import org.jacop.constraints.SoftAlldifferent;
import org.jacop.constraints.ViolationMeasure;
import org.jacop.core.Domain;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;


/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Master Student University Javeriana Cali.
*
*/


public  class SolverTres {

    public static void main(String[] args) {

        // Creating constraint store .
        // This object contains information about all the constraints and variables.
        Store store = new Store();

        IntVar[] var = new IntVar[10];
        for (int i=0; i<var.length; i++)
            var[i] = new IntVar(store, "v"+i, 0, 9);
        IntVar cost = new IntVar(store, "cost", 0, 20);

        store.imposeDecomposition(new SoftAlldifferent(var, cost, ViolationMeasure.DECOMPOSITION_BASED ));

        /*/store.imposeDecomposition(new Sequence(var, //variable list new IntervalDomain(1,1),
                                  new IntervalDomain(1,4), //set of values
                                                     10, // q, sequence length
                                                     1, // min
                                                     5 //max
                                  ));   */

        Search<IntVar> search = new DepthFirstSearch<IntVar>();
        SelectChoicePoint<IntVar> select =
                new InputOrderSelect<IntVar>(store, var,
                        new IndomainRandom<IntVar>());
        boolean result  = search.labeling(store, select);

        if ( result ){
           search.printAllSolutions();

            int numSolutions = search.getSolutionListener().solutionsNo();
            System.out.println("Number of Solutions: " + numSolutions);
            for(int s = 1; s <= numSolutions; s++) {
                Domain[] res = search.getSolutionListener().getSolution(s);
                int len = res.length;
                System.out.print("Solution #:" + s + " ");
                for(int x = 0; x < len; x++) {
                    System.out.print(res[x].toStringFull() +  " ");
                }
                System.out.println();
            }
        }
    }
}