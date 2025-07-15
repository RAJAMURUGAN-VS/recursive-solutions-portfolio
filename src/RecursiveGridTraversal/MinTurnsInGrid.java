package RecursiveGridTraversal;

import java.util.*;

class MinTurnsInGrid {

    /**
     * Problem: Minimum Turns to Destination in Grid
     * ---------------------------------------------
     * You are given a 2D grid of 1s and 0s, where:
     *   - 1 → A valid cell that can be traversed
     *   - 0 → A blocked cell that cannot be visited
     *
     * From a given starting cell (sr, sc), your task is to reach a destination cell (dr, dc)
     * using only 4-directional movement (up, down, left, right), **minimizing the number of
     * direction changes (turns)** in the path.
     *
     * Method: solve(int sr, int sc, int dr, int dc, int dir, int[][] grid, int count)
     * -------------------------------------------------------------------------------
     * A recursive DFS approach that explores all valid paths from source to destination,
     * tracking how many direction changes (turns) are made along each path.
     *
     * Logic:
     * • The algorithm marks visited cells with 2 to prevent cycles.
     * • It explores all 4 directions from each cell.
     * • For each movement:
     *     - If the movement direction is the same as the previous (`dir == i`), `count` is unchanged.
     *     - If the direction changes (`dir != i`), increment the `count` by 1.
     * • If destination is reached, update global minimum `minCount` with the current turn count.
     * • After exploring, backtrack by unmarking the visited cell (`grid[sr][sc] = 1`).
     *
     * Main Function:
     * • Reads the grid and coordinates from input.
     * • Adjusts indices from 1-based to 0-based.
     * • Calls `solve(...)` from the start point with initial direction = -1 and count = 0.
     * • Prints the minimum number of turns required to reach the destination.
     *
     * Example:
     * Input:
     * 6 6
     * 1 1 1 0 1 1
     * 1 0 1 0 1 0
     * 1 0 1 1 1 0
     * 1 0 0 0 1 1
     * 1 1 1 1 1 1
     * 0 0 0 0 0 1
     * 1 1
     * 6 6
     *
     * Grid:
     * [1, 1, 1, 0, 1, 1]
     * [1, 0, 1, 0, 1, 0]
     * [1, 0, 1, 1, 1, 0]
     * [1, 0, 0, 0, 1, 1]
     * [1, 1, 1, 1, 1, 1]
     * [0, 0, 0, 0, 0, 1]
     *
     * Path Chosen by Algorithm (min turns):
     * (0,0) ↓ (1,0) ↓ (2,0) ↓ (3,0) ↓ (4,0) → (4,1) → (4,2) → (4,3) → (4,4) → (4,5) ↓ (5,5)
     *
     * Explanation:
     * - This path avoids all walls (0s) and reaches the destination in just 2 direction changes:
     *     - Down → Right at (4,0)
     *     - Right → Down at (4,5)
     *
     * Output:
     * 2
     *
     * Complexity:
     * • Time  : O(4^(R×C)) – Worst case DFS explores all paths (pruned by visited cells).
     * • Space : O(R × C) – Due to recursion stack and visited marking.
     */

    public static int minCount=Integer.MAX_VALUE;

    public static void solve(int sr,int sc,int dr,int dc,int dir,int grid[][],int count) {

        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]!=1) 
            return;

        if(sr==dr && sc==dc) {
            minCount=Math.min(minCount,count);
            return;
        }
        

        grid[sr][sc]=2;

        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};


        for(int i=0;i<4;i++) {
            int r=sr+dx[i];
            int c=sc+dy[i];
            int curCount=(dir==-1 || dir==i)?count:count+1;
            solve(r,c,dr,dc,i,grid,curCount);
        }

        grid[sr][sc]=1;
    }
    
    public static void main(String args[]) {

        Scanner scan=new Scanner(System.in);
        int R=scan.nextInt();
        int C=scan.nextInt();

        int grid[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=scan.nextInt();

        int sr=scan.nextInt()-1;
        int sc=scan.nextInt()-1;
        int dr=scan.nextInt()-1;
        int dc=scan.nextInt()-1;

        solve(sr,sc,dr,dc,-1,grid,0);

        System.out.print(minCount);
    }
}
