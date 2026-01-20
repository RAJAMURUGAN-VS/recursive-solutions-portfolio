package RecursiveGridTraversal.Knights;
import java.util.*;

class Main {

    /**
     * Method: solve(int i, int j, int K)
     * ---------------------------------
     * Computes the probability that a knight remains on an 8×8 chessboard
     * after making exactly K moves, starting from position (i, j).
     *
     * A knight moves in an "L" shape with 8 possible directions.
     * Each move has an equal probability of 1/8.
     *
     * Logic:
     * • Base Cases:
     *     - If the current cell is outside the board, return 0.0
     *       (invalid path, probability lost).
     *     - If K == 0, return 1.0
     *       (valid position with no moves remaining).
     *
     * • Memoization:
     *     - dp[K][i][j] stores the probability of staying on the board
     *       from cell (i, j) with K moves remaining.
     *     - If already computed, return the stored value.
     *
     * • Recursive Case:
     *     - Try all 8 possible knight moves.
     *     - Recursively compute probability for K-1 moves.
     *     - Sum all probabilities and divide by 8.
     *
     * Input:
     * K = number of knight moves
     *
     * Output:
     * Probability (double) that the knight stays on the board
     * after K moves, printed up to 4 decimal places.
     *
     * Example:
     * Input:
     * 3
     *
     * Output:
     * 0.1250
     *
     * Complexity:
     * • Time  : O(K × 8 × 8 × 8) ≈ O(K)
     * • Space : O(K × 8 × 8) for DP table + recursion stack
     */
    
    public static int dx[]={-2,-2,-1,1,2,2,1,-1};
    public static int dy[]={-1,1,2,2,1,-1,-2,-2};
    public static double dp[][][];
    
    public static boolean isSafe(int i,int j) {
        
        return i>=0 && j>=0 && i<8 && j<8;
    }
    
    public static double solve(int i,int j,int K) {
        
        if(!isSafe(i,j))
            return 0.0;
            
        if(K==0)
            return 1.0;
            
        if(dp[K][i][j]!=-1)
            return dp[K][i][j];
            
        double p=0.0;
        
        for(int k=0;k<8;k++) {
            int nextI=i+dx[k];
            int nextJ=j+dy[k];
            p+=solve(nextI,nextJ,K-1)/8.0;
        }
        
        dp[K][i][j]=p;
        return  p;
    }
    
    public static void main(String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        
        dp=new double[K+1][8][8];
        
        for(int i=0;i<=K;i++)
            for(int j=0;j<8;j++)
                Arrays.fill(dp[i][j],-1);
        
        double res=solve(0,0,K);
        System.out.printf("%.4f",res);

        sc.close();
    }
}