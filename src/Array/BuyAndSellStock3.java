package Array;

/**
 * The third and one of the important variant uses dp.
 */
public class BuyAndSellStock3 {

    public static int maxProfit(int[] price) {
        int n = price.length;
        int[] profit = new int[n];

        // Get the maximum profit with only one transaction allowed.
        int maxPrice = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (price[i] > maxPrice)
                maxPrice = price[i];

            profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
        }

        // Get the maximum profit with two transactions allowed.
        int minPrice = price[0];
        for (int i = 1; i < n; i++) {
            if (price[i] < minPrice)
                minPrice = price[i];

            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - minPrice));
        }

        return profit[n - 1];
    }
}
