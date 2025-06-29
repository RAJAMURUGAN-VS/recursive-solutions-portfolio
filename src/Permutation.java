import java.util.*;

class Permutations {

    /*
     * Purpose:
     * --------
     * Generates all permutations of a given array of integers using backtracking.
     *
     * Example:
     * --------
     * Input:  [1, 2, 3]
     * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,2,1], [3,1,2]]
     *
     * How it works:
     * -------------
     * - We fix one index `ind` at a time, and try swapping it with every element from ind to end.
     * - After each swap, we recurse to fix the next index.
     * - Once we reach the last index (base case), we add the current array as a valid permutation.
     * - We backtrack (swap back) after recursion to restore the original state for the next branch.
     *
     * Key points:
     * -----------
     * - `nums` is passed by reference, so we must backtrack to undo changes after each recursive call.
     * - We store a **copy** of the current permutation using `new ArrayList<>(...)` to avoid reference issues.
     *
     * Time Complexity:
     * ----------------
     * - O(N × N!) 
     *   → There are N! permutations for an array of N elements.
     *   → Each permutation takes O(N) time to copy into the result list.
     *
     * Space Complexity:
     * -----------------
     * - O(N!) for the output list (res).
     * - O(N) for the recursion stack (depth = N).
     */

    public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res=new ArrayList<List<Integer>>();

        solve(nums,0,res);
        return res;
    }

    public static void solve(int nums[], int ind, List<List<Integer>> res) {

        int n=nums.length;

        if(ind==n-1) {
            List<Integer> subList=new ArrayList<>();

            for(int e : nums)
                subList.add(e);

            res.add(new ArrayList<>(subList));
            return;
        }

        for(int i=ind;i<n;i++) {
            swap(nums,i,ind);
            solve(nums,ind+1,res);
            swap(nums,i,ind);
        }
    }

    public static void swap(int nums[],int i,int j) {

        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int nums[]=new int[N];

        for(int i=0;i<N;i++)
            nums[i]=sc.nextInt();

        System.out.print(permute(nums));

        sc.close();
    }
}