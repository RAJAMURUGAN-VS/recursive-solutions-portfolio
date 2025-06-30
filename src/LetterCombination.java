import java.util.*;

class LetterCombination {

    /*
     * Letter Combinations of a Phone Number using Backtracking
     *
     * Problem:
     * --------
     * Given a string `digits` containing digits from 2 to 9, return all possible letter combinations 
     * that the number could represent based on the traditional phone keypad mapping.
     *
     * Example:
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     *
     * Approach:
     * ---------
     * 1. We use backtracking to generate all combinations character by character.
     * 2. At every index `ind`, we look up the string of letters mapped to the digit at that index.
     * 3. For each character in that string, we:
     *    - Append it to the current combination string `cur`.
     *    - Recurse to build the rest of the string by moving to the next digit (ind + 1).
     *    - After the recursive call, backtrack by removing the last character (undo the choice).
     * 4. When `ind == digits.length()`, we have a complete combination and add it to the result.
     * 5. An empty input should return an empty list.
     *
     * Time Complexity: O(4^n), where n is the number of digits — since each digit can have up to 4 letters.
     * Space Complexity: O(n), where n is the recursion depth (length of digits).
     */

    public static List<String> solve(String digits,int ind,String cur,List<String> res,Map<Character,String> map) {

        if(ind==digits.length()) {
            if(!cur.equals("")) 
                res.add(cur);
            return res;
        }

        String curAlphabets=map.get(digits.charAt(ind));

        for(int i=0;i<curAlphabets.length();i++) {
            cur+=curAlphabets.charAt(i);
            solve(digits,ind+1,cur,res,map);
            cur=cur.substring(0,cur.length()-1);
        }

        return res;
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        Map<Character,String> map=new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res=new ArrayList<>();
        String cur="";
        String digits=sc.next();

        System.out.print(solve(digits,0,cur,res,map));
        sc.close();
    }
}
