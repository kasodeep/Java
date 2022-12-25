package TS;

/*
    Time Complexity - Applying the asymptotic analysis to measure the time requirement of an algorithm as a function of input size is known as time complexity. 
    Total time complexity of a program is equal to the summation of all the running time of disconnected fragments.

    Types - 1) Worst Case : Big O()
            2) Best Case : Big Omega
            3) Average Case : Big T heta

    Space Complexity - Space Complexity is the extra memory space requirement of an algorithm by applying asymptotic analysis.
 */

public class Examples {

    public static void main(String[] args) {

        // for (int i = 0; i < N; i++) - O(N)
        // Nested Loops - O(N^2)

        // for(int i = 0; i < N; i++){
        // for(int i = 0; i < Math.sqrt(N), i++) - O(N * N^1/2)

        // for(int i = 0; i < N; i *= k) - O(logn) to base k.

        /*
         * int i, j, k = 0;
         * for (i = n / 2; i <= n; i++) {
         * for (j = 2; j <= n; j = j * 2) {
         * k = k + n / 2;
         * }
         * } - O(nlogn)
         */
    }
}
