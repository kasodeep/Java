package ArraysD2;

public class RotateBy90 {

    static void rotate(int[][] matrix)
    {
        int n = matrix.length;

        // transpose
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each column
        for(int i = 0; i < n; i++){
            int low = 0, high =  n - 1;
            while(low < high){
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;
                low++;
                high--;
            }
        }
    }
}
