import java.util.*;

class ReverseString  {
    
    /*
     * This method reverses a string using recursion.
     *
     * Parameters:
     * - N: the input string
     * - ind: the current index (starts from 0)
     * - res: the result string being built in reverse order
     *
     * Logic:
     * - Base Case: if ind reaches the end of the string, return the result string.
     * - Recursive Step: 
     *     - Take the current character (N.charAt(ind))
     *     - Add it in front of res to reverse the order
     *     - Call the method recursively with next index
     *
     * Example:
     * Input: "hello"
     * Calls: reverse("hello", 0, "") → reverse("hello", 1, "h") → ... → reverse("hello", 5, "olleh")
     * Output: "olleh"
     */

    public static String reverse(String N,int ind,String res) {
        if(ind==N.length()) 
            return res;
        res=N.charAt(ind)+res;
        return reverse(N,++ind,res);
    }
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        String N=sc.next();
        String res=reverse(N,0,"");
        System.out.print(res);
        sc.close();
    }    
}
