package Recursion;

public class NumberOfPaths {
    
    public static int numberOfPaths(int m , int n , int i , int j){

        // Constraints
        if(i >= m || j >= n)
                return 0;
        
        // Base-Case
        if(i == m - 1 && j == n - 1)
                return 1;

        // Self-Work
        return numberOfPaths(m , n , i + 1 , j) + numberOfPaths(m , n , i , j + 1);
}

    public static void main(String[] args) {
         
    }
}
