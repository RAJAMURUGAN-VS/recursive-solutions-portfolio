package RecursiveGridTraversal;

import java.util.*;

class LongestConsecutiveCharacter {

    public static int dx[]={-1,-1,-1,0,0,1,1,1};
    public static int dy[]={-1,0,1,-1,1,-1,0,1};

    public static int solve(int r,int c,char grid[][],char ch) {

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=ch)
            return 0;

        int max=0;

        for(int i=0;i<8;i++)
            max=Math.max(max,solve(r+dx[i],c+dy[i],grid,(char)(ch+1)));

        return 1+max;
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        char grid[][]=new char[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                grid[i][j]=sc.next().charAt(0);

        char start=sc.next().charAt(0);
        int res=0;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(grid[i][j]==start)
                    res=Math.max(res,solve(i,j,grid,start));

        System.out.println(res);
        sc.close();
    }
}