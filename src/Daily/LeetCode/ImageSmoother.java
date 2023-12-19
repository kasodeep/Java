package Daily.LeetCode;

public class ImageSmoother {

    public static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] smoothImg = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            sum += img[x][y];
                            count += 1;
                        }
                    }
                }
                smoothImg[i][j] = sum / count;
            }
        }
        return smoothImg;
    }

    public static void main(String[] args) {

    }
}
