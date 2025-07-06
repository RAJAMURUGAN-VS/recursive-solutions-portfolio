import java.util.*;

class CombinationSumFour {

    /**
     * Method: solve(int[] nums, int target)
     * -------------------------------------
     * Returns the number of possible combinations that add up to a given target using elements from `nums`.
     * Each number in `nums` may be used **unlimited times**. This is a variation of the **Combination Sum IV** problem.
     *
     * Logic:
     * • If target is 0 → return 1 (a valid combination has been formed).
     * • If target < 0  → return 0 (invalid path).
     *
     * • For each element in nums:
     *     - If nums[i] <= target → pick it, and recursively solve for `target - nums[i]`.
     *     - Accumulate the count of all such valid combinations.
     *
     * Example (nums = [1, 2, 3], target = 4):
     *   solve([1,2,3], 4)
     *     ├─ pick 1 → solve(3)
     *     │   ├─ pick 1 → solve(2)
     *     │   │   ├─ pick 1 → solve(1)
     *     │   │   │   ├─ pick 1 → solve(0) → return 1
     *     │   │   │   └─ ...
     *     ├─ pick 2 → solve(2)
     *     ├─ pick 3 → solve(1)
     *
     * Output: 7 (combinations: [1,1,1,1], [1,1,2], [1,2,1], [1,3], [2,1,1], [2,2], [3,1])
     *
     * Complexity:
     * • Time  : O(n^target) in brute force (without memoization), where `n` is nums.length.
     * • Space : O(target) for recursion stack depth.
     */

    public static int solve(int nums[],int target) {

        if(target<=0) 
            return target==0?1:0;

        int res=0;

        for(int i=0;i<nums.length;i++) 
            if(nums[i]<=target) 
                res+=solve(nums,target-nums[i]);

        return res;
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int nums[]=new int[N];

        for(int i=0;i<N;i++)
            nums[i]=sc.nextInt();

        int target=sc.nextInt();

        System.out.print(solve(nums,target));

        sc.close();
    }
}
