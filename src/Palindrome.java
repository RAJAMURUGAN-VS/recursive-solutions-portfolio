import java.util.*;
public class Palindrome
{

    /*
     * This method checks whether a given string is a palindrome using recursion.
     *
     * Logic:
     * - Base Case: If the current index `ind` crosses the middle of the string (`ind >= N / 2`),
     *   then all corresponding characters have matched, so return true.
     * - If characters at index `ind` and `N - ind - 1` do not match, return false.
     * - Else, recursively call isPalindrome with the next index.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N) — due to recursion stack
     *
     * Example:
     * Input: "madam"
     * Output: true
     */
    
    public static boolean isPalindrome(int ind,int N,String S)  {
        
        if(ind>=N/2)
            return true;
            
        if(S.charAt(ind)!=S.charAt(N-ind-1))
            return false;
            
        return isPalindrome(ind+1,N,S);
    }
    
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String S=sc.next();
		
		System.out.print(isPalindrome(0,S.length(),S));

        sc.close();
	}
}