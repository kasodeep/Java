package ArraysD2;

public class MultiplicationOfMatrix {

    static void multiply(int mat1[][], int r1, int c1, int mat2[][], int r2, int c2) {

        if (c1 != r2) {
            System.out.println("Invalid Input");
            return;
        }

        int[][] ans = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    ans[i][j] += (mat1[i][k] * mat2[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
