import java.util.*;

class NQueensAllSolutions {

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
     * Recursively attempts to place queens on the board using backtracking.
     * This function prints all valid N-Queen arrangements.
     *
     * Logic:
     * • Base Case:
     *     - If row == N, a complete valid configuration is found.
     *     - Print the current grid.
     *
     * • Try placing a queen in each column of the current row.
     *     - If it’s safe, place the queen (grid[row][col] = 1).
     *     - Recursively call solve for the next row.
     *     - Backtrack after the recursive call by removing the queen.
     *
     * Input:
     * N = 4
     *
     * Output:
     * 0 1 0 0 
     * 0 0 0 1 
     * 1 0 0 0 
     * 0 0 1 0 
     *
     * 0 0 1 0 
     * 1 0 0 0 
     * 0 0 0 1 
     * 0 1 0 0 
     *
     * Complexity:
     * • Time  : O(N!) – each queen has up to N choices in a row.
     * • Space : O(N^2) – board storage + recursion stack.
     */

    public static void solve(int row,int grid[][],int N) {

        if(row==N) {
            printNQueens(grid,N);
            return;
        }

        for(int col=0;col<N;col++)
            if(isSafe(row,col,grid,N)) {
                grid[row][col]=1;
                solve(row+1,grid,N);
                grid[row][col]=0;
            };
    }

    public static void printNQueens(int grid[][],int N) {

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }

        System.out.println();
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int grid[][]=new int[N][N];

        solve(0,grid,N);

        sc.close();
    }
}
