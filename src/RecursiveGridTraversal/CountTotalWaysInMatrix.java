package RecursiveGridTraversal;
import java.util.*;

class CountTotalWaysInMatrix {

    public static int R=0,C=0;

     /*
     * Method: findTotalWays(int r, int c)
     * ------------------------------------
     * This is a recursive method to count the number of unique ways to reach 
     * the bottom-right corner of an R x C matrix starting from position (r, c).
     *
     * Allowed moves: Only right and down.
     *
     * Base Case:
     * - If we are in the last row (r == R-1) or the last column (c == C-1),
     *   there's only one way to reach the bottom-right (keep moving straight).
     *
     * Recursive Case:
     * - Move one step down: findTotalWays(r+1, c)
     * - Move one step right: findTotalWays(r, c+1)
     * - Add both to get total paths from current cell.
     *
     * Time Complexity: Exponential (O(2^(R+C))) without memoization.
     *
     * Example: For a 3x3 grid, there are 6 ways to reach from (0,0) to (2,2)
     */

    public static int findTotalWays(int r, int c) {

        if(r==R-1 || c==C-1)
            return 1;
        
        return findTotalWays(r+1,c)+findTotalWays(r,c+1);
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();

        int totalWays=findTotalWays(0,0);

        System.out.print(totalWays);

        sc.close();
    }
}