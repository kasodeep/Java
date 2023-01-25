package Recursion;

public class AmstrongNumber {
    
    static int pow(int a, int b){

        // Base-Case
        if(b==0)
            return 1;

        if(b%2==0){
            return pow(a, b/2) * pow(a, b/2);
        }else{
            return pow(a, b/2) * pow(a, b/2) * a;
        }
    }

    static int ifAmstrong(int n, int m){

    // Base-Case
    if(n<=0){
        return 0;
    }

    // Self-Work
    return pow(n%10, m) + ifAmstrong(n/10,m);
}

    public static void main(String[] args) { 
          
        int n = 152;
        int m =ifAmstrong(n, 3);
        if(m==n){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
