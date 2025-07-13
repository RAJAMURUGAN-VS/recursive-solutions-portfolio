package RecursiveGridTraversal;

import java.util.Scanner;

class WordSearchBacktracking {

    /*
     * Method: solve(int r, int c, int R, int C, char[][] board, int ind, String word)
     * -------------------------------------------------------------------------------
     * This recursive method determines whether a given word exists in a character
     * grid starting from position (r, c). The word can be constructed by sequentially
     * adjacent cells (up, down, left, right), and each cell may only be used once.
     *
     * Allowed moves: Up, Down, Left, Right
     *
     * Base Case:
     * - If the current index 'ind' equals the word's length, return true (word found).
     * - If out of bounds or character mismatch or already visited, return false.
     *
     * Recursive Case:
     * - Temporarily mark the current cell as visited by changing its value.
     * - Explore all four directions: right, down, left, up.
     * - If any path returns true, propagate success.
     * - Restore the cell’s original character after exploration (backtracking).
     *
     * Time Complexity: O(R * C * 4^L), where L is the length of the word.
     *
     * Example Input:
     * Grid:
     * A B C E
     * S F C S
     * A D E E
     * Word: ABCCED
     * Output: true
     */

    public static boolean solve(int r,int c,int R,int C,char board[][],int ind,String word) {

        if(ind==word.length())
            return true;

        if(r>=R || c>=C || r<0 || c<0 || board[r][c]!=word.charAt(ind))
            return false;

        char orig=board[r][c];
        board[r][c]='-';

        boolean found=solve(r,c+1,R,C,board,ind+1,word) ||
        solve(r+1,c,R,C,board,ind+1,word) ||
        solve(r,c-1,R,C,board,ind+1,word) ||
        solve(r-1,c,R,C,board,ind+1,word);

        board[r][c]=orig;

        return found;
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        char board[][]=new char[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                board[i][j]=sc.next().charAt(0);

        String word=sc.next();

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(board[i][j]==word.charAt(0))
                    if(solve(i,j,board.length,board[0].length,board,0,word)) {
                        System.out.print("true");
                        return;
                    }

        System.out.print("false");

        sc.close();
    }
}
