import java.util.*;

class DecimalToBinary {

    /*
     * This method recursively converts a decimal number to binary and prints it.
     *
     * Base Case:
     * - If n == 0, we stop the recursion. Nothing is printed at this stage.
     *
     * Recursive Step:
     * - We call convert(n / 2) first to go to the most significant bit.
     *
     * Printing:
     * - After returning from the recursive call, we print (n % 2), which gives the current bit.
     * - This ensures binary digits are printed in the correct order (MSB to LSB).
     *
     * Example:
     * Input: 5
     * Call Stack: convert(5) → convert(2) → convert(1) → convert(0)
     * Print Order: 1 (from 1%2), 0 (from 2%2), 1 (from 5%2)
     * Output: 101
     * 
     * https://www.geeksforgeeks.org/problems/decimal-to-binary-1587115620/1
     */

    public static void convert(int n) {

        if(n==0)
            return;
        convert(n/2);
        System.out.print(n%2);
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        convert(n);
        sc.close();
    }
}
