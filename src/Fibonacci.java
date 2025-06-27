import java.util.*;

class Fibonacci {

    /*
     * This method calculates the Nth Fibonacci number using recursion.
     * 
     * How Fibonacci works:
     * fib(0) = 0
     * fib(1) = 1
     * fib(n) = fib(n-1) + fib(n-2) for n >= 2
     * 
     * For example:
     * fib(5) = fib(4) + fib(3)
     *        = (fib(3) + fib(2)) + (fib(2) + fib(1))
     *        = ...
     * 
     * This builds a binary recursion tree where each call computes two smaller Fibonacci numbers.
     * 
     * Time Complexity: O(2^N) — exponential, because it recalculates the same values many times.
     * Space Complexity: O(N) — due to the maximum depth of the recursion stack.
     * 
     * Note: This is not efficient for large N. For better performance, use memoization or iteration.
     */

    public static int fib(int N) {
        if(N==0) {
            return 0;
        }
        if(N==1) {
            return 1;
        }
        return fib(N-1)+fib(N-2);
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int res=fib(N);
        System.out.print(res);
        sc.close();
    }
}


