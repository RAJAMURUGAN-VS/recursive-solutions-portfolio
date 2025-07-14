package RecursiveGridTraversal;

import java.util.*;

class RoatingOranges {

    /**
     * Problem: Rotting Oranges (LeetCode #994)
     * -----------------------------------------
     * You are given a 2D grid where each cell can have one of three values:
     *   - 0 → an empty cell
     *   - 1 → a fresh orange
     *   - 2 → a rotten orange
     *
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten one becomes rotten.
     * Your task is to return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1.
     *
     * Method: solve(int r, int c, int[][] grid, int time)
     * ---------------------------------------------------
     * A recursive DFS approach that spreads the rot to adjacent fresh oranges.
     *
     * Logic:
     * • Starting from each initially rotten orange (value 2), this method recursively explores all 4 directions.
     * • A cell is updated only if:
     *     - It's a fresh orange (1), or
     *     - It has already rotted, but the current path reaches it in less time (grid[r][c] > time).
     *
     * • Recursive Step:
     *     - Assign the current cell the time it got rotten.
     *     - Call solve(...) on all 4 neighbors with time incremented by 1.
     *
     * Main Function:
     * • Traverse the grid and invoke `solve` from every rotten orange (value 2) with time = 2.
     * • After the recursive infection:
     *     - If any fresh orange (value 1) remains, return -1.
     *     - Otherwise, find the maximum rotten time and subtract 2 to get elapsed minutes.
     *
     * Example:
     * Input:
     * 3 5
     * 2 1 1 0 2
     * 1 1 0 1 1
     * 0 1 1 1 0
     *
     * Grid Over Time:
     * After DFS Spread:
     * [2, 3, 4, 0, 2]
     * [3, 4, 0, 4, 3]
     * [0, 5, 6, 5, 0]
     *
     * Explanation:
     * • The rot spreads from both rotten oranges at (0,0) and (0,4).
     * • The last fresh orange to rot is at (2,2), and it gets rotted at time = 6.
     * • So the minimum number of minutes = 6 - 2 = 4.
     *
     * Output:
     * 4
     *
     * Complexity:
     * • Time  : O(R × C) – Each cell is visited at most once.
     * • Space : O(R × C) – Due to recursion stack in the worst case (all cells connected).
     */

    public static void solve(int r,int c,int grid[][],int minutes) {

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)
            return;

        if(grid[r][c]==0 || (grid[r][c]>1 && grid[r][c]<minutes))
            return;

        grid[r][c]=minutes;

        solve(r-1,c,grid,minutes+1);
        solve(r,c+1,grid,minutes+1);
        solve(r+1,c,grid,minutes+1);
        solve(r,c-1,grid,minutes+1);
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int R=sc.nextInt();
        int C=sc.nextInt();

        int grid[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=sc.nextInt();

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(grid[i][j]==2) 
                    solve(i,j,grid,2);

        int minMinutes=0;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++) {
                if(grid[i][j]==1) {
                    System.out.print(-1);
                    return;
                }
                minMinutes=Math.max(minMinutes,grid[i][j]);
            } 

        System.out.print(Math.max(minMinutes-2,0));

        sc.close();
    }
}
