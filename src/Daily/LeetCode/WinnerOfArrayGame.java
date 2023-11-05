package Daily.LeetCode;

public class WinnerOfArrayGame {

    public static int getWinner(int[] arr, int k) {
        int win = 0;
        int ele = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ele) {
                win = 0;
                ele = arr[i];
            }
            if (++win == k) break;
        }
        return ele;
    }

    public static void main(String[] args) {

    }
}
