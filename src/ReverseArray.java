import java.util.*;

class Main {

    /**
     * Reverses the given character array in-place using recursion.
     *
     * Logic:
     * - The method swaps the element at index `ind` with the one at `N - ind - 1`.
     * - It then recursively calls itself with the next index.
     * - The base case is when `ind` reaches the middle of the array (`ind == N/2`),
     *   at which point all elements have been swapped.
     *
     * Example:
     * Input:  ['a', 'b', 'c', 'd']
     * Steps:
     *   swap(0, 3) → ['d', 'b', 'c', 'a']
     *   swap(1, 2) → ['d', 'c', 'b', 'a']
     *   ind = 2 == N/2 → recursion stops
     *
     * Time Complexity: O(N) – where N is the number of characters
     * Space Complexity: O(N) – recursion stack (due to function calls)
     */

    public static char[] reverse(char arr[], int ind) {

        int N=arr.length;
        if(ind==N/2)
            return arr;
        reverse(arr,ind+1);
        return swap(arr,ind,N-ind-1);
    }

    public static char[] swap(char arr[],int ind1, int ind2) {

        char t=arr[ind1];
        arr[ind1]=arr[ind2];
        arr[ind2]=t;
        return arr;
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        char arr[]=new char[N];

        for(int i=0;i<N;i++)
            arr[i]=sc.next().charAt(0);
        
        System.out.print(reverse(arr,0));
        sc.close();
    }
}
