import java.util.*;

class PalindromePartitioning {

    public static List<List<String>> solve(String s,int ind,int n,List<String> cur,List<List<String>> res) {

        if(ind==n) {
            res.add(new ArrayList<>(cur));
            return res;
        }

        for(int i=ind;i<n;i++) 
            if(isPalindrome(s,ind,i)) {
                cur.add(s.substring(ind,i+1));
                System.out.println(cur);
                solve(s,i+1,n,cur,res);
                cur.remove(cur.size()-1);
            }

        return res;
    }

    public static boolean isPalindrome(String s,int i,int j) {
        
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
    
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> cur=new ArrayList<>();

        res=solve(s,0,s.length(),cur,res);
        System.out.print(res);
        sc.close();
    }
}
