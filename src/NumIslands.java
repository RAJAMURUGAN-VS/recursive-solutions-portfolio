import java.util.*;

class NumIslands {

    /**
     * Method: solve(char[][] grid, int i, int j)
     * ------------------------------------------
     * Recursively marks all connected land cells ('1') starting from position (i, j)
     * by converting them into water ('0') to avoid revisiting, effectively "sinking" the island.
     *
     * Logic:
     * • The function explores all 4 directions from the current cell: Down, Left, Right, Up.
     * • A cell is processed only if:
     *     - It lies within the bounds of the grid.
     *     - It represents land ('1').
     *
     * • Recursive Step:
     *     - Change the current cell from '1' to '0' to mark it as visited (sink it).
     *     - Recursively call `solve` on all 4 adjacent cells.
     *
     * • Counting Islands:
     *     - In the main function, iterate through every cell in the grid.
     *     - On encountering a '1', call `solve` to sink the island and increment the island count.
     *
     * Example:
     * Input:
     * 4 5
     * 1 1 1 1 0
     * 1 1 0 1 0
     * 1 1 0 0 1
     * 0 0 1 1 0
     *
     * Output:
     * 3
     *
     * Explanation:
     * • Island 1: Top-left block — a large island connected horizontally and vertically.
     * • Island 2: Single-cell island at (2,4).
     * • Island 3: Bottom row — horizontally connected cells at (3,2) and (3,3).
     *
     * Complexity:
     * • Time  : O(R × C) – every cell is visited once at most.
     * • Space : O(R × C) – for the recursion stack in worst-case.
     */

    public static void solve(char grid[][],int i,int j) {

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return;

        grid[i][j]='0';

        solve(grid,i+1,j);
        solve(grid,i,j-1);
        solve(grid,i,j+1);
        solve(grid,i-1,j);
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int R=sc.nextInt();
        int C=sc.nextInt();

        char grid[][]=new char[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=sc.next().charAt(0);

        int noOfIslands=0;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(grid[i][j]=='1') {
                    solve(grid,i,j);
                    noOfIslands++;
                }
        
        System.out.print(noOfIslands);

        sc.close();
    }
}
