package Recursion;

public class SumOfNM {
    
    public static int rec(int n, int m) {

        // Base Case
        if (m == 1)
            return sumofn(n);

        // Self-Work
        int sum = rec(n, m - 1);
        return sumofn(sum);
}

    public static int sumofn(int n){

        // Base Case
        int ans = 0;
        if(n == 1){
            ans++;
            return ans;
        }

        // Self-Work
        ans += n + sumofn(n-1);
        return ans;
}

    public static void main(String[] args) {
        
    }
}
