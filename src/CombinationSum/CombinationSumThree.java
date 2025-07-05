import java.util.*;

class CombinationSumThree  {

    /**
     * Method: solve(int n, int target, int ind, List<Integer> cur, List<List<Integer>> res)
     * -------------------------------------------------------------------------------------
     * Finds all unique combinations of `n` distinct numbers from 1 to 9 that sum up to `target`.
     * The function uses **backtracking** to explore all valid combinations without repetitions.
     *
     * Logic:
     * • At each step, iterate from `ind` to 9:
     *    - If the current number `i` is greater than `target`, no point in exploring further (pruning).
     *    - Pick the number `i`, add to `cur`, and reduce `n` and `target`.
     *    - Recurse with `i+1` to avoid using the same number again.
     *    - After recursion, backtrack by removing the last added number.
     *
     * • Base Case:
     *    - If `n == 0` and `target == 0`, it means a valid combination is formed; add a copy to `res`.
     *    - If `n == 0` or `target < 0`, return as no valid combination can be formed from here.
     *
     * Example (n = 3, target = 7):
     *   solve(3, 7, 1, [], [])
     *     ├─ pick 1 → solve(2, 6, 2, [1], [])
     *     │   ├─ pick 2 → solve(1, 4, 3, [1,2], [])
     *     │   │   ├─ pick 3 → solve(0, 1, 4, [1,2,3], [])
     *     │   │   └─ ...
     *     │   └─ pick 4 → solve(1, 2, 5, [1,4], []) → ...
     *     └─ pick 2 → solve(2, 5, 3, [2], []) → ...
     *
     * Output: [[1,2,4]]
     *
     * Complexity:
     * • Time  : O(C(9, n)) – combinations of 9 numbers taken `n` at a time.
     * • Space : O(n)       – maximum recursion depth due to building each combination.
     */

    public static void solve(int n,int target,int ind,List<Integer> cur,List<List<Integer>> res) {

        if(n==0 || target<0) {
            if(n==0 && target==0)
                res.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=ind;i<=9;i++) {
            if(i>target)
                return;
            cur.add(i);
            solve(n-1,target-i,i+1,cur,res);
            cur.remove(cur.size()-1);
        }
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> cur=new ArrayList<>();

        solve(n,target,1,cur,res);

        System.out.print(res);

        sc.close();
    }
}
