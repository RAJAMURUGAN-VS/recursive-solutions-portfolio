import java.util.*;

class SurvivorInCircle {

    /**
     * This method finds the safe (surviving) position in a circle where every kth person is eliminated,
     * known as the Josephus Problem.
     *
     * Logic:
     * - Base Case: If only one person remains in the list, return that person (the survivor).
     * - Recursive Case:
     *     1. Calculate the index of the next person to eliminate using: (ind + k - 1) % positions.size()
     *     2. Remove the person at that index from the list.
     *     3. Recur with the updated list and the new starting index.
     * 
     * This creates a call stack like:
     * findSafePosition(3, 0, [1,2,3,4,5]) → remove 3 → [1,2,4,5]
     * findSafePosition(3, 2, [1,2,4,5])   → remove 1 → [2,4,5]
     * findSafePosition(3, 0, [2,4,5])     → remove 5 → [2,4]
     * findSafePosition(3, 2, [2,4])       → remove 2 → [4]
     * findSafePosition(3, 0, [4])         → survivor = 4
     *
     * Example:
     * Input: n = 5, k = 3
     * Output: 4 (person at position 4 survives)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack and dynamic list
     *
     * Note: This is a clean recursive approach to Josephus Problem. Can be optimized using mathematical recurrence for large n.
     */

    public static int findSafePosition(int k,int ind,List<Integer> positions) {
        
        if(positions.size()==1)
            return positions.get(0);  // Base case: only one person remains
            
        int nextInd=(ind+k-1)%positions.size();
        
        positions.remove(nextInd);
        
        return findSafePosition(k,nextInd,positions);
    }

    public static void main(String args[]) {
    
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(); // Total number of people in the circle
        int k=sc.nextInt(); // Step count for elimination

        List<Integer> positions=new ArrayList<Integer>();

        for(int i=1;i<=n;i++)
            positions.add(i);

        System.out.print(findSafePosition(k,0,positions));

        sc.close();
    }
}
