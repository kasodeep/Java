package Recursion;

public class ConvertToBinary {
    
    static int toBinary(int num){

        // Base-Case
        if(num == 0 || num == 1){
            return num;
        }

        // Sef-Work
        return toBinary(num/2) * 10 + num%2;
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println(toBinary(n));
    }
}
