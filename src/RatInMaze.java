import java.util.*;

class RatInMaze {

    /**
     * Method: solve(int[][] maze, int i, int j, int N, String cur, ArrayList<String> paths)
     * -------------------------------------------------------------------------------------
     * Recursively explores all valid paths from the top-left (0,0) to the bottom-right (N-1,N-1)
     * of an N x N maze grid, collecting path directions using backtracking.
     *
     * Logic:
     * • The function explores all 4 directions from the current cell: Down, Left, Right, Up.
     * • A cell can only be visited if:
     *     - It is within the bounds of the grid.
     *     - It is not a wall (represented by 0).
     *     - It has not been visited before in the current path (marked as 2).
     *
     * • Base Case:
     *     If (i == N-1 && j == N-1), a valid path has been found.
     *     → Add the path string `cur` to the result list `paths`.
     *
     * • Backtracking:
     *     - Mark the current cell as visited by setting maze[i][j] = 2.
     *     - Explore all four directions recursively with updated path string.
     *     - After exploring, unmark the cell (restore original value) to allow other paths.
     *
     * Example:
     * Input:
     * maze = [[1, 0, 0, 0],
     *         [1, 1, 0, 1],
     *         [1, 1, 0, 0],
     *         [0, 1, 1, 1]]
     *
     * Output:
     * ["DDRDRR", "DRDDRR"]
     *
     * Path letters:
     * - D → Down
     * - L → Left
     * - R → Right
     * - U → Up
     *
     * Complexity:
     * • Time  : O(4^(N^2)) – worst case explores all directions from each cell.
     * • Space : O(N^2) – for recursion stack and path string storage.
     */

    public static void solve(int maze[][],int i,int j,int N,String cur,ArrayList<String> paths) {
        
        if(i==N-1 && j==N-1) {
            paths.add(cur);
            return;
        }
        
        if(i<0 || j<0 || i>=N || j>=N || maze[i][j]==0 || maze[i][j]==2)
            return;
            
        int orig=maze[i][j];
        maze[i][j]=2;
            
        solve(maze,i+1,j,N,cur+'D',paths);
        solve(maze,i,j-1,N,cur+'L',paths);
        solve(maze,i,j+1,N,cur+'R',paths);
        solve(maze,i-1,j,N,cur+'U',paths);
        
        maze[i][j]=orig;
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int maze[][]=new int[N][N];

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                maze[i][j]=sc.nextInt();

        ArrayList<String> paths=new ArrayList<>();
        String cur="";
        
        solve(maze,0,0,maze.length,cur,paths);

        System.out.print(paths);

        sc.close();
    }
}