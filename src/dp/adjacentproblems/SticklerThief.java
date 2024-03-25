package dp.adjacentproblems;

public class SticklerThief {

    public static int FindMaxSum(int[] arr, int n) {
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);

        int[] moneyLooted = new int[arr.length];
        moneyLooted[0] = arr[0];
        moneyLooted[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            moneyLooted[i] = Math.max(arr[i] + moneyLooted[i - 2], moneyLooted[i - 1]);
        }
        return moneyLooted[n - 1];
    }
}
