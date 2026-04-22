package RecursiveGridTraversal;

import java.util.*;

class MaxSubArrayWithFlip {

  public static int getMaxSub(int ind,int a[],int N,int flip,int dir,int dp[][][]) {

    //Out-of-bound (child-node -> end of recursion) [base case]
    if(ind==N) {
      return 0;
    }

    if(dp[ind][dir][flip]!=-1) {
      return dp[ind][dir][flip];
    } 

    int count=0;

    //flip
    if(flip==1) {
      count=Math.max(count,1+getMaxSub(ind+1,a,N,0,(dir==1?0:1),dp));
    }

    //no flip
    if((dir==1 && a[ind]>=0) || (dir==0 && a[ind]<0)) 
      count=Math.max(count,1+getMaxSub(ind+1,a,N,flip,dir,dp));
    else
      count=Math.max(count,getMaxSub(ind+1,a,N,flip,dir,dp));

    return dp[ind][dir][flip]=count;
  }

  public static void main(String args[]) {

    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();

    int a[]=new int[N];

    for(int i=0;i<N;i++)
      a[i]=sc.nextInt();

    int dp[][][]=new int[N][2][2];

    for(int i=0;i<N;i++)
        for(int j=0;j<2;j++)
          Arrays.fill(dp[i][j],-1);

    int maxCount=0;

    for(int i=0;i<N;i++) {
      maxCount=Math.max(maxCount,1+getMaxSub(i+1,a,N,1,(a[i]>=0?1:0),dp));
    }

    System.out.print(maxCount);  

    sc.close();
  }
}


//  4 true false => (5)
//  4 false false => 


// ind=0
// a 
// N 
// 1
// flip=true 
// dir=true


// public static void getMaxSub(int ind,int a[],int N,int count,boolean flip,boolean dir)



// getMaxSub(0+1,a,N,1+1,false,false);


// 8
// 4


// Stack 

       
// 1 2 3 -1 6 7 -2 4 -5 -6
// 8


// get
// getMaxSub(1,a,N,2,false,false);
// getMaxSub(0,a,N,1,true,true);

