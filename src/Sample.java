import java.util.*;

class Sample {

    public static int solve(int sr,int sc,int dr,int dc,int jr,int jc,int grid[][],int dp[][],boolean visited[][]) {

        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]==1)
            return Integer.MAX_VALUE;

        if(visited[sr][sc])
            return Integer.MAX_VALUE;

        if(sr==dr && sc==dc) 
            return 0;

        if(dp[sr][sc]!=-1)
            return dp[sr][sc];

        visited[sr][sc]=true;

        int minPath=Integer.MAX_VALUE;

        int dx[]={jr,jc,jr,-1*jr,jc,-1*jc,-1*jr,-1*jc};
        int dy[]={jc,jr,-1*jc,jc,-1*jr,jr,-1*jc,-1*jr};

        for(int i=0;i<8;i++) {
            int curPath=solve(sr+dx[i],sc+dy[i],dr,dc,jr,jc,grid,dp,visited);
            if(curPath!=Integer.MAX_VALUE)
                minPath=Math.min(minPath,curPath+1);
        }

        visited[sr][sc]=false;

        return dp[sr][sc]=minPath;
    }

    public static void main(String args[]) {

        Scanner scan=new Scanner(System.in);
        int R=scan.nextInt();
        int C=scan.nextInt();

        int grid[][]=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=scan.nextInt();

        int sr=scan.nextInt();
        int sc=scan.nextInt();
        int dr=scan.nextInt();
        int dc=scan.nextInt();
        int jr=scan.nextInt();
        int jc=scan.nextInt();

        int dp[][]=new int[R][C];

        for(int row[] : dp)
            Arrays.fill(row,-1);

        boolean visited[][]=new boolean[R][C];

        int res=solve(sr,sc,dr,dc,jr,jc,grid,dp,visited);

        System.out.print(res==Integer.MAX_VALUE?-1:res);

        scan.close();
    }
}
