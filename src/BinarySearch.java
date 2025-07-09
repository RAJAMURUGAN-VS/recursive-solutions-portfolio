import java.util.*;

class BinarySearch {

    /**
     * Performs a recursive binary search to find the **first occurrence** of a given key
     * in a sorted integer array (possibly with duplicates).
     *
     * Logic:
     * - Computes the middle index `mid` from `left` and `right`.
     * - If `nums[mid]` matches the key:
     *     - Checks whether it is the first occurrence (either at index 0 or the previous element is smaller).
     *     - If yes, returns `mid`; otherwise, continues search in the left half.
     * - If `nums[mid]` is greater than the key, search continues in the left half.
     * - If `nums[mid]` is less than the key, search continues in the right half.
     *
     * Base Case:
     * - When `left > right`, it means the key is not present in the array. Returns -1.
     *
     * Example:
     * Input: nums = [1, 2, 2, 2, 3, 4], key = 2
     * Steps:
     *   mid = 2 → nums[2] = 2
     *   nums[1] = 2 → not the first occurrence → recurse left
     *   mid = 1 → nums[1] = 2
     *   nums[0] = 1 → first occurrence found at index 1
     *
     * Time Complexity: O(log N) – where N is the number of elements
     * Space Complexity: O(log N) – recursion stack (in worst case)
     */

    public static int findIndex(int left,int right,int nums[],int key) {

        if(left>right)
            return -1;

        int mid=(left+right)/2;

        if(nums[mid]==key)
            if(mid==0 || nums[mid-1]<key)
                return mid;
            else
                return findIndex(left,mid-1,nums,key);
        else if(nums[mid]>key)
            return findIndex(left,mid-1,nums,key);
        return findIndex(mid+1,right,nums,key);
        
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int nums[]=new int[N];

        for(int i=0;i<N;i++)
            nums[i]=sc.nextInt();

        int key=sc.nextInt();
        int ind=findIndex(0,N-1,nums,key);
        
        if(ind==-1)
            System.out.print(key+"is not present.");
        else
            System.out.print(key+" appears at index "+ind+".");

        sc.close();
    }
}
