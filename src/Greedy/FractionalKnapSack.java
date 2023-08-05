package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given the weights and profits of N items, Find the maximum profit that can be accommodated in weight W.
 */
public class FractionalKnapSack {

    public static void main(String[] args) {
        List<Integer> value = List.of(60, 100, 150, 120);
        List<Integer> weights = List.of(10, 20, 50, 15);
        int W = 30;

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            items.add(new Item(value.get(i), weights.get(i)));
        }

        items.sort(new ItemComparator());
        int profit = 0;
        for (int i = 0; i < items.size() && W > 0; i++) {
            Item item = items.get(i);
            if (item.weight <= W) {
                profit += item.value;
                W -= item.weight;
            } else {
                profit += item.value / item.weight * W;
                W = 0;
            }
        }

        System.out.println(profit);
    }

    private static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o2.value / o2.weight, o1.value / o1.weight);
        }
    }

    private static class Item {
        Integer value;
        Integer weight;

        Item(Integer value, Integer weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" + "value=" + value + ", weight=" + weight + '}';
        }
    }
}
