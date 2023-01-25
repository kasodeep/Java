package Recursion;

public class CheckPrime {
    
    static boolean isPrime(int n, int i){

        // Self-Work
        if(n%i == 0){
            return false;
        }

        // Base-Case
        if(i*i <= n)
            return true;
            
        // Recursion
        return isPrime(n, i++);
    }

    public static void main(String[] args) {
        
        // Not Handling 2
        int n = 97;
        System.out.println(isPrime(n, 2));
    }
}
