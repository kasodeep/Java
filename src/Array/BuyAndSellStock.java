package Array;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 3, 8, 9};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0], max_profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) buy = prices[i];
            else if (prices[i] - buy > max_profit) max_profit = prices[i] - buy;
        }
        return max_profit;
    }
}
