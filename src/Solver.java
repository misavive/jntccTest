import org.jacop.core.*;
import org.jacop.constraints.*;
import org.jacop.search.*;


/**
* Created with IntelliJ IDEA.
* By: Misael Viveros Castro
* Master Student University Javeriana Cali.
*
*/


public  class Solver {

    public static void main(String[] args) {

        // Creating constraint store .
        // This object contains information about all the constraints and variables.
        Store store = new Store();

        // Creating Variables (finite domain variables).
        // There are as many variables as there are letters/digits.
        IntVar a = new IntVar(store, "a", 0, 9);
        IntVar b = new IntVar(store, "b", 0, 9);
        IntVar c = new IntVar(store, "c", 0, 9);
        IntVar d = new IntVar(store, "d", 0, 9);
        IntVar e = new IntVar(store, "e", 0, 9);
        IntVar f = new IntVar(store, "f", 0, 9);
        IntVar g = new IntVar(store, "g", 0, 9);
        IntVar h = new IntVar(store, "h", 0, 9);
        IntVar i = new IntVar(store, "i", 0, 9);
        IntVar j = new IntVar(store, "j", 0, 9);

        IntVar diff = new IntVar(store, "diff", 0, 99999);

        // Creating arrays for IntVars
        IntVar digits[] = { a,b,c,d,e,f,g,h,i,j };
        IntVar abcde[]  = { a,b,c,d,e };
        IntVar fghij[]  = { f,g,h,i,j };

        // Creating and imposing constraints

        // Imposing inequalities constraints between letters
        // Only one global constraint to make sure that all digits are different.
        store.impose(new Alldifferent(digits));

        int[] weights5 = { 10000, 1000, 100, 10, 1 };
        IntVar value_abcde = new IntVar(store, "v_abcde", 0, 99999);
        IntVar value_fghij = new IntVar(store, "v_fghij", 0, 99999);

        // Constraints for getting value for words
        store.impose(new SumWeight (abcde, weights5, value_abcde));
        store.impose(new SumWeight (fghij, weights5, value_fghij));

        // abcde > fghij
        store.impose(new XgtY (value_abcde, value_fghij));


        // Main equation of the problem:
        //    diff = abcde - fghij
        //  ->
        //    diff + fghij = abcde
        // It would be niced with a constraint XminusYeqZ(...), though
        store.impose(new XplusYeqZ (diff, value_fghij, value_abcde));


        // Specyfing search , the search variables, the heuristic to choose
        // next variable and the heuristic to choose assigned value
        SelectChoicePoint select = new SimpleSelect (digits,
                new MostConstrainedStatic (), new IndomainMin ());

        // HakankUtil.toXML(store, -1, ".", "LeastDiff.xml");

        // The actual search
        // Use the Depth First Search with default solution listener, which
        Search label = new DepthFirstSearch ();
        label.getSolutionListener().setSolutionLimit(100);
        label.getSolutionListener().recordSolutions(true);
         boolean result = label.labeling(store, select);
        //boolean result = label.labeling(store, select, diff);

        System.out.println("store: " + store);
        // int[][] allSolutions = label.getSolutionListener().getSolutions();

        // It prints out the (last) solution if it was found.
        if(result) {
            System.out.println("Solution found.");
            System.out.print(" "     + value_abcde.value() + " - "   + value_fghij.value());
            System.out.println(" = " + diff.value());
            label.getSolutionListener().printAllSolutions();

        }

        /*// just testing...
        int numSolutions = label.getSolutionListener().solutionsNo();
        System.out.println("Number of Solutions: " + numSolutions);
        for(int s = 1; s <= numSolutions; s++) {
            Domain[] res =  label.getSolutionListener().getSolution(s);
            int len = res.length;
            System.out.print("Solution #:" + s + " ");
            for(int x = 0; x < len; x++) {
                System.out.print(res[x].toString() +  " ");
            }
            System.out.println();
        }       */


    }
}