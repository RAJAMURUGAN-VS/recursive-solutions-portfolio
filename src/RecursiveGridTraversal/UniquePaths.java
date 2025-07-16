package RecursiveGridTraversal;

import java.util.*;

class UniquePaths {

    /**
     * Problem: Unique Paths
     * -----------------------------------------
     * You are given a 2D grid where:
     *   - 1 → Starting cell (only one)
     *   - 2 → Ending cell (only one)
     *   - 0 → Empty cell that must be visited
     *   - -1 → Obstacle that cannot be visited
     *
     * Your task is to find the number of **unique paths** from the start cell to the end cell,
     * such that **all non-obstacle cells are visited exactly once**.
     *
     * Method: solve(int r, int c, int[][] grid, int nonObstacle)
     * ----------------------------------------------------------
     * A recursive DFS approach that explores all valid paths from the starting point.
     * It tracks how many non-obstacle cells are yet to be visited.
     *
     * Logic:
     * • If the current cell is out of bounds or an obstacle, return 0.
     * • If the end cell (value = 2) is reached and all non-obstacle cells are visited (nonObstacle == 0), return 1.
     * • Mark the current cell as visited by setting its value to -1.
     * • Explore all 4 directions (up, down, left, right), recursively subtracting 1 from nonObstacle.
     * • Backtrack by restoring the cell to its original value after recursion.
     * • Sum all valid paths found and return the result.
     *
     * Main Function:
     * • Reads the grid size and grid values from input.
     * • Locates the start cell (value 1) and counts all non-obstacle (0) cells.
     * • Calls `solve(...)` from the start cell with `nonObstacle + 1` to include the start cell itself.
     * • Prints the total number of unique paths.
     *
     * Example:
     * Input:
     * 3 4
     * 1 0 0 0
     * 0 0 0 0
     * 0 0 2 -1
     *
     * Grid:
     * [1, 0, 0, 0]
     * [0, 0, 0, 0]
     * [0, 0, 2, -1]
     *
     * Explanation:
     * - There are exactly 2 unique paths from (0,0) to (2,2) that cover all 0s once.
     *
     * Output:
     * 2
     *
     * Complexity:
     * • Time  : O(4^(R×C)) – Worst-case explores all possible unique paths.
     * • Space : O(R × C) – Due to recursion stack and grid modifications.
     */

    public static int solve(int r,int c,int grid[][],int nonObstacle) {

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==-1)
            return 0;

        if(grid[r][c]==2) {
            if(nonObstacle==0) 
                return 1;
            return 0;
        }

        int paths=0;

        grid[r][c]=-1;

        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};

        for(int i=0;i<4;i++) 
            paths+=solve(r+dx[i],c+dy[i],grid,nonObstacle-1);

        grid[r][c]=0;

        return paths;
    }

    public static void main(String args[]) {
    
        Scanner scan=new Scanner(System.in);
        int R=scan.nextInt();
        int C=scan.nextInt();
        int grid[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=scan.nextInt();

        int sr=0,sc=0;
        int nonObstacle=0;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(grid[i][j]==1) {
                    sr=i;
                    sc=j;
                }
                else if(grid[i][j]==0)
                    nonObstacle++;
        
        System.out.print(solve(sr,sc,grid,nonObstacle+1));

        scan.close();
    }
}
