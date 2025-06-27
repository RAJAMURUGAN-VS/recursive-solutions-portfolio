import java.util.*;

class ReverseNumberpublic  {

    /*
     * This method reverses a number recursively.
     *
     * Parameters:
     * - N: the current part of the number still to be processed
     * - res: the result built up so far (initially 0)
     *
     * Logic:
     * - Base Case: if N == 0, we return res as the final reversed number.
     * - Recursive Step: 
     *     - Extract last digit (N % 10)
     *     - Add it to res after shifting res left by 1 digit (res * 10)
     *     - Call reverse with N / 10 and updated res
     *
     * Example:
     * Input: 123
     * Calls: reverse(123,0) → reverse(12,3) → reverse(1,32) → reverse(0,321)
     * Output: 321
     */

    public static int reverse(int N,int res) {
        if(N==0)
            return res;
        res=res*10+N%10;
        return reverse(N/10,res);
    }
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        if(N==0) {
            System.out.print(0);
            return;
        }
        int res=reverse(N,0);
        System.out.print(res);
        sc.close();
    }    
}
