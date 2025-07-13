package RecursiveGridTraversal;

import java.util.Scanner;

class SurroundedRegions {

    /*
     * Method: solve(char[][] board)
     * ------------------------------
     * This method captures all regions in a 2D board surrounded by 'X'.
     * A region is a group of connected 'O's that are not connected to any border.
     * Any such region should be flipped to 'X'. Border-connected 'O's remain unchanged.
     *
     * Helper: find(int r, int c, int R, int C, char[][] board)
     * - Performs DFS from a given cell and marks safe 'O's (connected to the border) with 'S'.
     *
     * Steps:
     * 1. Run DFS on all border 'O's and mark them temporarily as 'S'.
     * 2. Traverse the board:
     *    - Flip remaining 'O' to 'X' (as they are surrounded).
     *    - Restore 'S' back to 'O' (as they are safe).
     *
     * Time Complexity: O(R × C)
     * Space Complexity: O(R × C) recursion stack in worst case.
     *
     * Example Input:
     * X O X X
     * X O X X
     * O X O X
     * O X X X
     *
     * Output:
     * X O X X
     * X O X X
     * O X X X
     * O X X X
     */

    public static void solve(int r,int c,int R,int C,char board[][]) {

        if(r<0 || c<0 || r>=R || c>=C || board[r][c]!='O')
            return;

        board[r][c]='S';

        solve(r,c+1,R,C,board);
        solve(r+1,c,R,C,board);
        solve(r,c-1,R,C,board);
        solve(r-1,c,R,C,board);
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        char board[][]=new char[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                board[i][j]=sc.next().charAt(0);

        // Border rows

        for(int j=0;j<C;j++) {
            if(board[0][j]=='O')
                solve(0,j,R,C,board);
            if(board[R-1][j]=='O')
                solve(R-1,j,R,C,board);
        }

         // Border columns

        for(int i=0;i<R;i++) {
            if(board[i][0]=='O')
                solve(i,0,R,C,board);
            if(board[i][C-1]=='O')
                solve(i,C-1,R,C,board);
        }

        // Final flip

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='S')
                    board[i][j]='O';

        // Print Solution

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }

        sc.close();
    }
}
