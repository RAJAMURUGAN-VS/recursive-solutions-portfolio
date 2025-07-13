package RecursiveGridTraversal;

import java.util.*;

class FloodFill {

    /*
     * Problem: Flood Fill (LeetCode #733)
     * -----------------------------------
     * You are given an image represented by a 2D grid of integers.
     * Each integer represents the color of a pixel.
     * You are also given the coordinates (sr, sc) of a starting pixel,
     * and a new color to apply.
     *
     * Fill all 4-directionally connected pixels with the same color as the starting pixel
     * and replace them with the new color.
     *
     * Method: solve(int sr, int sc, int color, int curColor, int[][] image)
     * ----------------------------------------------------------------------
     * - Base Case:
     *   - If out of bounds or pixel is not the original color → return.
     *
     * - Recursive Case:
     *   - Color the pixel.
     *   - Recurse in 4 directions (right, down, left, up).
     *
     * Time Complexity: O(R × C)
     * Space Complexity: O(R × C) — due to recursion stack
     *
     * Example:
     * Input:
     * 3 3
     * 1 1 1
     * 1 1 0
     * 1 0 1
     * 1 1 2
     *
     * Output:
     * 2 2 2
     * 2 2 0
     * 2 0 1
     */

    public static void solve(int sr,int sc,int color,int curColor,int image[][]) {

        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=curColor)
            return;

        image[sr][sc]=color;

        solve(sr,sc+1,color,curColor,image);
        solve(sr+1,sc,color,curColor,image);
        solve(sr,sc-1,color,curColor,image);
        solve(sr-1,sc,color,curColor,image);
    }
    
    public static void main(String args[]) {

        Scanner scan=new Scanner(System.in);
        int R=scan.nextInt();
        int C=scan.nextInt();
        int image[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                image[i][j]=scan.nextInt();
        
        int sr=scan.nextInt();
        int sc=scan.nextInt();
        int color=scan.nextInt();

        int curColor=image[sr][sc];
        if(color!=curColor)
            solve(sr,sc,color,image[sr][sc],image);

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++)
                System.out.print(image[i][j]+" ");
            System.out.println();
        }

        scan.close();
    }
}
