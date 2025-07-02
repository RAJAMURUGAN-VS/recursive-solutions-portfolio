import java.util.*;

class AllSubsequenceOfString {

    /*
     * Method: solve(String input, int ind, String output)
     * -----------------------------------------------------
     * This is a recursive method to generate and print all subsequences
     * of a given string `input`.
     *
     * A subsequence is a sequence derived by deleting zero or more 
     * characters from the original string without changing the order.
     *
     * Base Case:
     * - If `ind` equals input.length(), we've reached the end of the string.
     *   At this point, the built `output` is a complete subsequence, so we print it.
     *
     * Recursive Case:
     * - Include the current character in the output: 
     *   solve(input, ind + 1, output + input.charAt(ind))
     * - Exclude the current character (skip it): 
     *   solve(input, ind + 1, output)
     * - These two calls ensure all 2^n subsequences are covered.
     *
     * Time Complexity: O(2^n), where n is the length of the input string.
     * Space Complexity: O(n), due to the recursive call stack and output string.
     *
     * Example:
     * Input: "abc"
     * Output: abc ab ac a bc b c (and an empty subsequence)
    */


    public static void solve(String input,int ind,String output) {

        if(ind==input.length()) {
            System.out.print(output+" ");
            return;
        }
            
        solve(input,ind+1,output+input.charAt(ind));
        solve(input,ind+1,output);
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        String input=sc.next();

        solve(input,0,"");

        sc.close();
    }
}