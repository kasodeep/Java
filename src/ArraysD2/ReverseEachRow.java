package ArraysD2;

import java.util.Scanner;

public class ReverseEachRow {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the dimensions of the 2D array: ");
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int a = 0, b = m - 1;
            while (a < b) {
                int temp = mat[i][a];
                mat[i][a] = mat[i][b];
                mat[i][b] = temp;
                a++;
                b--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
