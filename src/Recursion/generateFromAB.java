package Recursion;

import java.util.Scanner;

public class generateFromAB {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the length of both the arrays: ");
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[] A = new int[m];
        int[] B = new int[n];
        System.out.println("Enter the elements of first array: ");
        for (int i = 0; i < m; i++) {
            A[i] = scn.nextInt();
        }

        System.out.println("Enter the elements of second array: ");
        for (int i = 0; i < n; i++) {
            B[i] = scn.nextInt();
        }

        int[] C = new int[m + n];
        generate(A, B, C, 0, 0, m, n, 0, true);
    }

    public static void generate(int[] A, int[] B, int[] C, int i, int j, int m, int n, int len, boolean flag) {
        if (flag) {
            if (len != 0) {
                printArr(C, len + 1);
            }
            for (int k = i; k < m; k++) {
                if (len == 0) {
                    C[len] = A[k];
                    generate(A, B, C, k + 1, j, m, n, len, false);
                } else if (A[k] > C[len]) {
                    C[len + 1] = A[k];
                    generate(A, B, C, k + 1, j, m, n, len + 1, false);
                }
            }
        } else {
            for (int l = j; l < n; l++) {
                if (B[l] > C[len]) {
                    C[len + 1] = B[l];
                    generate(A, B, C, i, l + 1, m, n, len + 1, true);
                }
            }
        }
    }

    public static void printArr(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
