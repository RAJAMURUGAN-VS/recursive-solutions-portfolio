import java.util.*;

class PalindromePartitioning {

    /*
     * Palindrome Partitioning using Backtracking
     *
     * Problem:
     * --------
     * Given a string `s`, partition it such that every substring in the partition is a palindrome.
     * Return all possible palindrome partitioning of `s`.
     *
     * Example:
     * Input: "aab"
     * Output: [[a, a, b], [aa, b]]
     *
     * Approach:
     * ---------
     * 1. We use backtracking to explore all possible partitions of the input string.
     * 2. At every index `ind`, we try to form substrings from `ind` to every `i` (where i >= ind).
     * 3. If the substring s[ind...i] is a palindrome, we add it to the current list `cur`.
     * 4. We then recursively solve for the next part of the string (i+1 to end).
     * 5. When `ind == n` (end of string), we’ve found one valid partition. Add it to the result.
     * 6. After recursive call, we backtrack by removing the last element added (undo).
     *
     * Time Complexity: O(2^n) — Because each character can be partitioned or not
     * Space Complexity: O(n) — Recursion stack + current path
     */

    public static List<List<String>> solve(String s,int ind,int n,List<String> cur,List<List<String>> res) {

        if(ind==n) {
            res.add(new ArrayList<>(cur));
            return res;
        }

        for(int i=ind;i<n;i++) 
            if(isPalindrome(s,ind,i)) {
                cur.add(s.substring(ind,i+1));
                solve(s,i+1,n,cur,res);
                cur.remove(cur.size()-1);
            }

        return res;
    }

    public static boolean isPalindrome(String s,int i,int j) {
        
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> cur=new ArrayList<>();

        res=solve(s,0,s.length(),cur,res);
        System.out.print(res);
        sc.close();
    }
}
