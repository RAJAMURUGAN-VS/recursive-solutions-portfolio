import java.util.*;

class CombinationSum {

    /**
     * Method: solve(int[] arr, int target, int ind, List<Integer> cur, List<List<Integer>> res)
     * ------------------------------------------------------------------------------------------
     * Finds all unique combinations of numbers from `arr` (with unlimited reuse) that sum up to `target`.
     * The function uses **backtracking** with pruning to avoid unnecessary recursive calls.
     *
     * Logic:
     * • At each index `ind`, we have two choices:
     *    1. **Pick**  the current number `arr[ind]`:
     *       → Include it in the current list `cur`, subtract it from `target`,  
     *         and **recurse on the same index** since elements can be reused.
     *    2. **Skip**  the current number:
     *       → Move to the next index by calling `solve` with `ind + 1`.
     *
     * • Base Case:
     *    If `ind == arr.length`, all elements have been considered.
     *    - If `target == 0`, we've found a valid combination; add a copy of `cur` to `res`.
     *    - Otherwise, return (invalid path).
     *
     * Example (arr = [2, 3, 6, 7], target = 7):
     *   solve([2,3,6,7], 0, [], 7, [])
     *     ├─ pick 2 → solve(..., 0, [2], 5)
     *     │   ├─ pick 2 → solve(..., 0, [2,2], 3)
     *     │   │   ├─ pick 2 → solve(..., 0, [2,2,2], 1)
     *     │   │   └─ skip 2 → solve(..., 1, [2,2], 3)
     *     │   └─ skip 2 → ...
     *     └─ pick 7 → solve(..., 3, [7], 0) → add [7] to result
     *
     * Output: [[2,2,3], [7]]
     *
     * Complexity:
     * • Time  : O(2^target) – since numbers can be reused, and many combinations are possible.
     * • Space : O(target)  – maximum depth of recursion is bounded by `target/ min(arr[i])`.
     */


    public static void solve(int arr[],int target,int ind,List<Integer> cur,List<List<Integer>> res) {

        if(ind==arr.length) {
            if(target==0)
                res.add(new ArrayList<Integer>(cur));
            return;
        }

        //pick (pruning)
        if(arr[ind]<=target) {
            cur.add(arr[ind]);
            solve(arr,target-arr[ind],ind,cur,res);
            cur.remove(cur.size()-1);
        }
        //no pick
        solve(arr,target,ind+1,cur,res);
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N];

        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        int target=sc.nextInt();

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> cur=new ArrayList<>();

        solve(arr,target,0,cur,res);

        System.out.print(res);

        sc.close();
    }
}
