package RecursiveGridTraversal;

import java.util.*;

class CountPathsWithObstacles {

    /*
     * Method: solve(int r, int c, int R, int C, int[][] grid)
     * -------------------------------------------------------
     * This recursive method counts the number of unique ways to reach the 
     * bottom-right corner of an R x C matrix from position (r, c), avoiding obstacles.
     *
     * Allowed moves: Only right and down.
     * Obstacles: Represented by '1' in the grid. Cannot pass through them.
     *
     * Base Case:
     * - If we reach out of bounds (r == R or c == C), return 0.
     * - If the current cell is blocked (grid[r][c] == 1), return 0.
     * - If we reach the destination cell (r == R-1 and c == C-1), return 1.
     *
     * Recursive Case:
     * - Mark current cell as visited (temporarily) to avoid revisiting.
     * - Move one step down: solve(r+1, c, ...)
     * - Move one step right: solve(r, c+1, ...)
     * - Add both to get total paths from current cell.
     * - Unmark cell after recursion (backtracking).
     *
     * Time Complexity: Exponential (O(2^(R+C))) without memoization.
     *
     * Example Input (3x3 Grid):
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * Output: 2
     */

    public static int solve(int r,int c,int R,int C,int grid[][]) {

        if(r==R-1 && c==C-1)
            return 1;

        if(r==R || c==C || grid[r][c]==1)
            return 0;

        int paths=0;

        grid[r][c]=1;

        paths+=solve(r+1,c,R,C,grid)+solve(r,c+1,R,C,grid);

        grid[r][c]=0;

        return paths;
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int R=sc.nextInt();
        int C=sc.nextInt();

        int grid[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=sc.nextInt();

        if(grid[0][0]==1 || grid[R-1][C-1]==1)
            System.out.print(0);
        else
            System.out.print(solve(0,0,R,C,grid));

        sc.close();
    }
}