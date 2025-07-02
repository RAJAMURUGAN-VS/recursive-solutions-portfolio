import java.util.*;

class SubsequenceSumEqualsK {

    /**
     * Method: solve(int[] input, int ind, List<Integer> output, int target, int sum)
     * ------------------------------------------------------------------------------
     * Finds and prints **all subsequences whose elements add up to `target`**.
     *
     * Logic:
     * • At every position `ind`, we have two choices:
     *      1. **Pick**  the element `input[ind]`  
     *         → add it to `output`, add its value to `sum`, recurse on next index.
     *      2. **Skip**  the element  
     *         → undo the pick (remove last element, subtract its value), recurse.
     *
     * • Base Case  
     *   When `ind == input.length`, every element has been considered.  
     *   If the running `sum` equals `target`, we print the current `output`
     *   (one valid subsequence); otherwise we simply return.
     *
     * Example (input = [1, 2, 3], target = 3):
     *   solve([1,2,3], 0, [], 3, 0)
     *     ├─ pick 1  → solve(..., 1, [1], 3, 1)
     *     │   ├─ pick 2  → solve(..., 2, [1,2], 3, 3)   → print [1, 2]
     *     │   └─ skip 2  → solve(..., 2, [1],   3, 1)
     *     │       └─ pick 3 → solve(..., 3, [1,3], 3, 4) (sum≠target, discard)
     *     └─ skip 1 → solve(..., 1, [], 3, 0)
     *         ├─ pick 2  → solve(..., 2, [2], 3, 2)
     *         │   └─ pick 3 → solve(..., 3, [2,3], 3, 5) (discard)
     *         └─ skip 2  → solve(..., 2, [], 3, 0)
     *             └─ pick 3 → solve(..., 3, [3], 3, 3)   → print [3]
     *
     * Output: [1, 2] and [3]
     *
     * Complexity:
     * • Time  : O(2ⁿ) – two choices (pick/skip) per element.
     * • Space : O(n)  – recursion depth plus the `output` list.
     */

    public static void solve(int[] input,int ind,List<Integer> output,int target,int sum) {

        if(ind==input.length) {

            if(sum==target)
                System.out.println(output);

            return;
        }

        //pick

        output.add(input[ind]);
        sum+=input[ind];
        solve(input,ind+1,output,target,sum);

        //not pick

        output.remove(output.size()-1);
        sum-=input[ind];
        solve(input,ind+1,output,target,sum);
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int target=sc.nextInt();

        int input[]=new int[N];

        List<Integer> output=new ArrayList<>();

        for(int i=0;i<N;i++) 
            input[i]=sc.nextInt();

        solve(input,0,output,target,0);

        sc.close();
    }
}
