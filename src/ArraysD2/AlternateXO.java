package ArraysD2;

import java.util.Scanner;

public class AlternateXO {

    static char[][] generateXO(int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElements = 0;

        char[][] matrix = new char[r][c];
        boolean flag = true;
        while (totalElements < r * c) {

            // topRow -> leftCol to rightCol
            for (int j = leftCol; j <= rightCol && totalElements < r * c; j++) {
                if (flag) matrix[topRow][j] = 'X';
                else matrix[topRow][j] = 'O';
                totalElements++;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for (int i = topRow; i <= bottomRow && totalElements < r * c; i++) {
                if (flag) matrix[i][rightCol] = 'X';
                else matrix[i][rightCol] = 'O';
                totalElements++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && totalElements < r * c; j--) {
                if (flag) matrix[bottomRow][j] = 'X';
                else matrix[bottomRow][j] = 'O';
                totalElements++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i = bottomRow; i >= topRow && totalElements < r * c; i--) {
                if (flag) matrix[i][leftCol] = 'X';
                else matrix[i][leftCol] = 'O';
                totalElements++;
            }
            leftCol++;
            flag = !flag;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of rows and columns");
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] ans = generateXO(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
