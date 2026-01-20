package RecursiveGridTraversal.Knights;
import java.util.*;

class KnightsTour {

    /**
     * Method: solve(int i, int j, int[][] grid, int N, int moves)
     * ------------------------------------------------------------
     * Attempts to find a Knight's Tour path using recursive backtracking.
     * A knight moves in "L" shapes (8 possible directions) on a chessboard.
     * The function places move numbers in the grid, starting from (0,0).
     *
     * Logic:
     * • Base Case:
     *     - If all cells are visited (moves == N*N), return true.
     *
     * • For each of the 8 possible knight moves:
     *     - Check if the next cell is within bounds and unvisited.
     *     - Place the move number on that cell.
     *     - Recursively call solve() for the next move.
     *     - If the recursion returns true, the tour is complete.
     *     - Else, backtrack: unmark the current cell (set it back to -1).
     *
     * • The tour starts at cell (0,0), with move count starting from 0.
     *
     * Input:
     * 5
     *
     * Output:
     *  0 |  3 | 16 |  9 | 24 |
     * ___  ___  ___  ___  ___  
     * 17 |  8 |  1 |  4 | 15 |
     * ___  ___  ___  ___  ___  
     *  2 |  5 | 18 | 23 | 10 |
     * ___  ___  ___  ___  ___  
     *  7 | 20 | 11 | 14 | 25 |
     * ___  ___  ___  ___  ___  
     * 12 |  6 | 21 | 26 | 13 |
     * ___  ___  ___  ___  ___  
     *
     * Complexity:
     * • Time  : O(8^(N^2)) – worst-case exponential due to 8 choices per move.
     * • Space : O(N^2) – grid size and recursion stack.
     */

    public static boolean isSafe(int i,int j,int grid[][],int N) {
        
        return i>=0 && j>=0 && i<N && j<N && grid[i][j]==-1;
    }
    
    public static boolean solve(int i,int j,int grid[][],int N,int moves) {
        
        if(moves==N*N)
            return true;
        
        int dx[]={-2,-2,-1,1,2,2,1,-1};
        int dy[]={-1,1,2,2,1,-1,-2,-2};
        
        for(int k=0;k<8;k++) {
            int nextI=i+dx[k];
            int nextJ=j+dy[k];
            if(isSafe(nextI,nextJ,grid,N)) {
                grid[nextI][nextJ]=moves;
                if(solve(nextI,nextJ,grid,N,moves+1))
                    return true;
                else
                    grid[nextI][nextJ]=-1;
            }
        }

        return false;
    }
    
    public static void printGrid(int grid[][]) {
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++)
                System.out.printf("%2d | ",grid[i][j]);
            System.out.println();
            for(int j=0;j<grid[i].length;j++)   
                System.out.print("___  ");
            System.out.println("\n");
        }
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int grid[][]=new int[N][N];
		
		for(int i=0;i<N;i++)
		    Arrays.fill(grid[i],-1);
		
		grid[0][0]=0;
		
		if(solve(0,0,grid,N,1))
		    printGrid(grid);
		else 
		    System.out.print("Solution does not exists");

        sc.close();
    }
}
