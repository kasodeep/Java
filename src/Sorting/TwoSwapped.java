package Sorting;

public class TwoSwapped {
    public static void sortArr(int[] num, int n) {
        if (n <= 1) return;

        int x = -1;
        int y = -1;
        int prev = num[0];

        for (int i = 1; i < n; i++) {
            if (prev > num[i]) {
                if (x == -1) {
                    x = i - 1;
                }
                y = i;
            }
            prev = num[i];
        }

        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }

    public static void main(String[] args) {
        int[] num = {3, 8, 6, 7, 5, 9, 10};
        int n = num.length;
        sortArr(num, n);

        for (int number : num) {
            System.out.print(number + " ");
        }
    }
}
