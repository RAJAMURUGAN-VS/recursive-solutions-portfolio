import java.util.*;

class TailRecursion {

    /*
     * This is a simple example of tail recursion (not head recursion).
     * 
     * Function: printNumbers(int n)
     * - It prints numbers from n down to 1 in decreasing order.
     * - Base case: if n == 0, the recursion stops.
     * - Recursive case: prints n, then calls printNumbers(n - 1)
     * 
     * Example:
     * Input: 5
     * Output:
     * 5
     * 4
     * 3
     * 2
     * 1
     * 
     * This is a TAIL RECURSION because:
     * - The recursive call is the **last action** in the function.
     * - No operation is pending after the recursive call.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) — due to recursion stack
     */

    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printNumbers(N);
        sc.close();
    }
}