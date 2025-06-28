import java.util.*;

class TowerOfHanoi {

    /*
     * This is a classic example of a **divide and conquer** recursive algorithm.
     * 
     * Problem: Tower of Hanoi
     * ----------------------------------------
     * You are given `n` disks placed on a source rod. The task is to move all disks 
     * from the source rod to the destination rod following these rules:
     * 1. Only one disk can be moved at a time.
     * 2. A disk can only be placed on top of a larger disk or an empty rod.
     * 3. There are three rods: source, helper (auxiliary), and destination.
     * 
     * Function: solve(int N, int from, int aux, int to)
     * -------------------------------------------------
     * - Recursively moves N disks from `from` rod to `to` rod using `aux` as helper.
     * - Base case: if N == 0, no moves are needed.
     * - Recursive case:
     *     1. Move N-1 disks from `from` → `aux` (using `to` as helper)
     *     2. Move the Nth disk from `from` → `to`
     *     3. Move N-1 disks from `aux` → `to` (using `from` as helper)
     * - For each move, it prints the action and counts the step.
     * 
     * Example Input: N = 3
     * Output:
     * move disk 1 from rod 1 to rod 3
     * move disk 2 from rod 1 to rod 2
     * move disk 1 from rod 3 to rod 2
     * move disk 3 from rod 1 to rod 3
     * move disk 1 from rod 2 to rod 1
     * move disk 2 from rod 2 to rod 3
     * move disk 1 from rod 1 to rod 3
     * Total steps to solve Tower of Hanoi: 7
     * 
     * Time Complexity: O(2^n) — exponential growth due to recursive branching
     * Space Complexity: O(n) — recursion stack depth equals number of disks
     */

    public static int solve(int N,int from,int aux,int to) {
        
        if(N==0)
            return 0;

        int moves=0;
        moves+=solve(N-1,from,to,aux);
        moves++;
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        moves+=solve(N-1,aux,from,to);

        return moves;
    }

    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int moves=solve(N,1,2,3); 

        System.out.print("Total steps to solve Tower of Hanoi: "+moves);
        sc.close();
    }
}
