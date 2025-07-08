import java.util.*;

class NQueensSingleSolution {

    /**
     * Method: isSafe(int row, int col, int[][] grid, int N)
     * -----------------------------------------------------
     * Checks whether placing a queen at position (row, col) is safe.
     * A position is safe if no other queen exists in:
     *  • the same column,
     *  • the upper-left diagonal,
     *  • the upper-right diagonal.
     *
     * Returns:
     * • true if the position is safe.
     * • false if placing a queen causes conflict.
     */

    public static boolean isSafe(int row,int col,int grid[][],int N) {

        //Scan vertically above (same column).

        for(int i=row-1;i>=0;i--)
            if(grid[i][col]==1)
                return false;

        //Scan upper-left diagonal.        

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
            if(grid[i][j]==1)
                return false;

        //Scan upper-right diagonal.

        for(int i=row-1,j=col+1;i>=0 && j<N;i--,j++)
            if(grid[i][j]==1)
                return false;

        return true;
    }

    /**
     * Method: solve(int row, int[][] grid, int N)
     * --------------------------------------------
     * Attempts to find any one valid solution for N-Queens using backtracking.
     *
     * Logic:
     * • Base Case:
     *     - If row == N, a valid board is found. Return true.
     *
     * • For each column in the current row:
     *     - If placing a queen is safe:
     *         - Place the queen.
     *         - Recursively solve for the next row.
     *         - If that leads to a solution, return true.
     *         - Else, backtrack (remove the queen).
     *
     * Returns:
     * • true if a solution is found.
     * • false if no configuration is valid.
     *
     * Input:
     * 4
     *
     * Output:
     * 0 1 0 0 
     * 0 0 0 1 
     * 1 0 0 0 
     * 0 0 1 0 
     *
     * Complexity:
     * • Time  : O(N!) – in worst case.
     * • Space : O(N^2) – board + recursion stack.
     */

    public static boolean solve(int row,int grid[][],int N) {

        if(row==N) 
            return true;

        for(int col=0;col<N;col++)
            if(isSafe(row,col,grid,N)) {
                grid[row][col]=1;
                if(solve(row+1,grid,N))
                    return true;
                grid[row][col]=0;
            }

        return false;
    }

    public static void printNQueens(int grid[][],int N) {

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int grid[][]=new int[N][N];

        if(solve(0,grid,N))
            printNQueens(grid,N);
        else
            System.out.print("Solution does not exists");

        sc.close();
    }
}
