import java.util.*;

class SumOfNaturalNumbers {

    /*
     * This method calculates the sum of the first N natural numbers using recursion.
     *
     * Logic:
     * - Base Case: If n <= 0, return 0 (end of recursion).
     * - Recursive Case: Return n + sum(n - 1)
     *
     * This creates a call stack like:
     * sum(3) = 3 + sum(2)
     *        = 3 + 2 + sum(1)
     *        = 3 + 2 + 1 + sum(0)
     *        = 3 + 2 + 1 + 0 = 6
     *
     * Example:
     * Input: 5
     * Output: 15 (i.e., 5 + 4 + 3 + 2 + 1)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack
     *
     * Note: This is a simple use of recursion, but can be replaced with the formula n*(n+1)/2 for better efficiency.
     */

    public static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = sum(N);
        System.out.println("Sum of first " + N + " natural numbers is: " + result);
        sc.close();
    }
}
