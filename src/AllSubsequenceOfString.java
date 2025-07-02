import java.util.*;

class AllSubsequenceOfString {

    /*
     * Generates and prints all subsequences of a given string using recursion.
     *
     * Logic:
     * - At each index `ind`, we have two choices:
     *     1. Include the current character in the subsequence.
     *     2. Exclude the current character from the subsequence.
     * - We recursively explore both choices, building the `output` string along the way.
     * - The base case occurs when `ind == input.length()`, meaning we’ve made decisions
     *   for all characters. At this point, we print the built `output` as one subsequence.
     *
     * Example:
     * Input:  "abc"
     * Steps:
     *   solve("abc", 0, "") → 
     *     → solve("abc", 1, "a") 
     *         → solve("abc", 2, "ab") 
     *             → solve("abc", 3, "abc") → print "abc"
     *             → solve("abc", 3, "ab")  → print "ab"
     *         → solve("abc", 2, "a") 
     *             → solve("abc", 3, "ac") → print "ac"
     *             → solve("abc", 3, "a")  → print "a"
     *     → solve("abc", 1, "") 
     *         → solve("abc", 2, "b") 
     *             → solve("abc", 3, "bc") → print "bc"
     *             → solve("abc", 3, "b")  → print "b"
     *         → solve("abc", 2, "") 
     *             → solve("abc", 3, "c")  → print "c"
     *             → solve("abc", 3, "")   → print ""
     *
     * Total: 8 subsequences (2^3), including the empty string.
     *
     * Time Complexity: O(2^n) – where n is the length of the string
     * Space Complexity: O(n)  – due to the recursive call stack
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