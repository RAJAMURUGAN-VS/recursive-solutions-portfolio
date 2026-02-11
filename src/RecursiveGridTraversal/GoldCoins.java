package RecursiveGridTraversal;

import java.util.*;

public class GoldCoins {

    /*
     * Method: solve(int row, int[][] grid, int prevCol, int R, int C, int points)
     * ---------------------------------------------------------------------------
     * This recursive method finds the maximum number of gold coins that can be collected
     * by selecting exactly one box from each row of the grid.
     *
     * Conditions:
     * - From each row, only one box can be chosen.
     * - If a box is chosen in a row, the box directly below it (same column) 
     *   cannot be chosen in the next row.
     *
     * Parameters:
     * - row     : current row being processed
     * - grid    : matrix containing coin values
     * - prevCol : column index chosen in the previous row
     * - R, C    : total rows and columns
     * - points  : total coins collected so far
     *
     * Base Case:
     * - When row == R (all rows processed), update maxPoints with the maximum coins collected.
     *
     * Recursive Case:
     * - Try selecting each column in the current row.
     * - Skip the column if it is the same as the previously selected column.
     * - Add the current cell value to points and move to the next row.
     *
     * Time Complexity:
     * - Exponential: O(C^R) due to exploring all valid column combinations.
     */
  
    public static int maxPoints;
  
    public static void solve(int row,int grid[][],int prevCol,int R,int C,int points) {
      
        if(row==R) {
            maxPoints=Math.max(maxPoints,points);
            return; 
        } 
      
        for(int col=0;col<C;col++) 
            if(row==0 || col!=prevCol)
                solve(row+1,grid,col,R,C,points+grid[row][col]);
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        for(int i=0;i<N;i++) {
            int R=sc.nextInt();
            int C=sc.nextInt();
            int grid[][]=new int[R][C];
            maxPoints=0;

            for(int r=0;r<R;r++) 
                for(int c=0;c<C;c++) 
                    grid[r][c]=sc.nextInt();
            
            solve(0,grid,-1,R,C,0);
            System.out.println(maxPoints); 
        }
        sc.close();
    }
}