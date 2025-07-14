package RecursiveGridTraversal;

import java.util.*;

class MaxAreaOfIsland {

    /**
     * Problem: Max Area of Island (LeetCode #695)
     * -------------------------------------------
     * Given a 2D grid where 1 represents land and 0 represents water, find the largest area
     * of a connected island. An island is a group of adjacent 1s connected 4-directionally
     * (horizontal or vertical). Return the maximum area of any island in the grid.
     *
     * Method: solve(int r, int c, int[][] grid)
     * -----------------------------------------
     * Recursively computes the area of an island starting from the given cell (r, c).
     * 
     * Logic:
     * • The function explores all 4 directions from the current land cell: Up, Right, Down, Left.
     * • A cell is counted only if:
     *     - It lies within the bounds of the grid.
     *     - It represents land (value is 1).
     * 
     * • Recursive Step:
     *     - Mark the current cell as visited by setting grid[r][c] = 0.
     *     - Add 1 (for the current cell), and recursively compute area from all 4 directions.
     * 
     * Main Function:
     * • Read the grid dimensions and values.
     * • Iterate through each cell in the grid.
     * • If a cell is land (1), call solve() to compute its island area.
     * • Track and update the maximum area encountered.
     *
     * Example:
     * Input:
     * 8 13
     * 0 0 1 0 0 0 0 1 0 0 0 0 0
     * 0 0 0 0 0 0 0 1 1 1 0 0 0
     * 0 1 1 0 1 0 0 0 0 0 0 0 0
     * 0 1 0 0 1 1 0 0 1 0 1 0 0
     * 0 1 0 0 1 1 0 0 1 1 1 0 0
     * 0 0 0 0 0 0 0 0 0 0 1 0 0
     * 0 0 0 0 0 0 0 1 1 1 0 0 0
     * 0 0 0 0 0 0 0 1 1 0 0 0 0
     *
     * Output:
     * 6
     *
     * Explanation:
     * • The largest island has 6 connected 1s (land).
     * • There may be multiple islands; the goal is to find the one with maximum area.
     *
     * Complexity:
     * • Time  : O(R × C) – each cell is visited at most once.
     * • Space : O(R × C) – recursion stack in the worst case (all land).
     */

    public static int solve(int r,int c,int grid[][]) {

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1)
            return 0;

        int count=1;

        grid[r][c]=0;

        count+=solve(r-1,c,grid)+
        solve(r,c+1,grid)+
        solve(r+1,c,grid)+
        solve(r,c-1,grid);

        return count;
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int R=sc.nextInt();
        int C=sc.nextInt();

        int grid[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=sc.nextInt();

        int maxArea=0;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(grid[i][j]==1) {
                    int curArea=solve(i,j,grid);
                    maxArea=Math.max(maxArea,curArea);
                }

        System.out.print(maxArea);

        sc.close();
    }
}
