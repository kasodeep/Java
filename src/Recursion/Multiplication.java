package Recursion;

public class Multiplication {
    
    static int multiply(int a, int b){

        // Swapping
        if(b>a){
            int t = a;
            a = b;
            b = t;
        }

        // Base Case
        if(b==1){
            return a;
        }

        // Self-Work
        return multiply(a, b-1) + a;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        System.out.println(multiply(x, y));
    }
}
