import java.util.*;

class CombinationSumTwo {

    /**
     * Method: solve(int[] candidates, int target, int ind, List<Integer> cur, List<List<Integer>> res)
     * -------------------------------------------------------------------------------------------------
     * Finds all unique combinations where numbers sum to the target. Each number can be used **once**.
     * Input array must be sorted before calling this method to skip duplicates and enable pruning.
     *
     * Example:
     * Input: candidates = [1, 1, 2, 5, 6], target = 6
     * Sorted: [1, 1, 2, 5, 6]
     *
     * Tree:
     * solve([1,1,2,5,6], 6, 0, [], res)
     * ├─ pick 1 (i=0) → solve(..., 5, [1])
     * │   ├─ pick 1 (i=1) → solve(..., 4, [1,1])
     * │   │   ├─ pick 2 (i=2) → solve(..., 2, [1,1,2])
     * │   │   │   └─ pick 5 (i=3) → exceeds target → backtrack
     * │   │   │   └─ pick 6 (i=4) → exceeds target → backtrack
     * │   │   └─ pick 5 (i=3) → solve(..., -1, [1,1,5]) → invalid
     * │   │   └─ pick 6 (i=4) → solve(..., -2, [1,1,6]) → invalid
     * │   ├─ skip duplicate 1 (i=1)
     * │   └─ pick 2 (i=2) → solve(..., 3, [1,2])
     * │       ├─ pick 5 (i=3) → solve(..., -2, [1,2,5]) → invalid
     * │       └─ pick 6 (i=4) → solve(..., -3, [1,2,6]) → invalid
     * │   └─ pick 5 (i=3) → solve(..., 0, [1,5]) → add to res
     * │   └─ pick 6 (i=4) → solve(..., -1, [1,6]) → invalid
     * ├─ skip duplicate 1 (i=1)
     * ├─ pick 2 (i=2) → solve(..., 4, [2])
     * │   └─ pick 5 (i=3) → solve(..., -1, [2,5]) → invalid
     * │   └─ pick 6 (i=4) → solve(..., -2, [2,6]) → invalid
     * ├─ pick 5 (i=3) → solve(..., 1, [5])
     * │   └─ pick 6 (i=4) → solve(..., -5, [5,6]) → invalid
     * └─ pick 6 (i=4) → solve(..., 0, [6]) → add to res
     *
     * Result: [[1,5], [6]]
     *
     * Notes:
     * • Elements are only picked once → move to i+1 in recursion.
     * • Duplicate elements are skipped unless it's the first occurrence at that level.
     * • Backtracking undoes each pick before returning to try other options.
     */


    public static void solve(int candidates[],int target,int ind,List<Integer> cur,List<List<Integer>> res) {

        if(target==0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=ind;i<candidates.length;i++) {
            if(candidates[i]>target)
                break;
            if((i==ind || candidates[i-1]!=candidates[i]) && candidates[i]<=target) {
                cur.add(candidates[i]);
                solve(candidates,target-candidates[i],i+1,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int arr[]=new int[N];

        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        int target=sc.nextInt();

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();

        solve(arr,target,0,cur,res);

        System.out.print(res);

        sc.close();
    }
}