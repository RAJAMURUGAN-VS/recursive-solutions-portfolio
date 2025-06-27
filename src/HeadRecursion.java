import java.util.*;

class HeadRecursion {

    /*
     * This method prints numbers from 1 to N using recursion.
     *
     * Technique: Head Recursion
     * - The recursive call is made **before** the print statement.
     * - So the method keeps going deeper (from N down to 1), then prints while returning.
     *
     * Base Case:
     * - If N == 0, stop recursion.
     *
     * Recursive Case:
     * - Call printNumbers(N - 1), then print N.
     *
     * Example:
     * Input: 5
     * Output:
     * 1
     * 2
     * 3
     * 4
     * 5
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N) — due to recursion stack
     *
     * Note:
     * This is called HEAD RECURSION because the function does its recursive call first, then performs the action.
     */

    public static void printNumbers(int N) {
        if(N==0) {
            return;
        }
        printNumbers(N-1);
        System.out.println(N);
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        printNumbers(N);
        sc.close();
    }
}