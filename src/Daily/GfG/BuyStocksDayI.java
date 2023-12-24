package Daily.GfG;

import java.util.ArrayList;
import java.util.Comparator;

public class BuyStocksDayI {

    public static int buyMaximumProducts(int n, int k, int[] price) {
        ArrayList<Pair> v = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            v.add(new Pair(price[i], i + 1));

        v.sort(new Comparator<>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.first - p2.first;
            }
        });

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int quantity = Math.min(v.get(i).second, k / v.get(i).first);
            ans += quantity;
            k -= v.get(i).first * quantity;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

    public static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
