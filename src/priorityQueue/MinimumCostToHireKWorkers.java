package priorityQueue;

import java.util.*;

public class MinimumCostToHireKWorkers {

    public static double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Pair> ratio = new ArrayList<>();

        int n = quality.length, qualitySum = 0;
        double res, maxRate = 0.0;

        for (int i = 0; i < n; ++i) {
            ratio.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
        ratio.sort(Comparator.comparingDouble(Pair::getKey));

        for (int i = 0; i < k; ++i) {
            qualitySum += ratio.get(i).getValue();
            maxRate = Math.max(maxRate, ratio.get(i).getKey());
            maxHeap.offer(ratio.get(i).getValue());
        }

        res = maxRate * qualitySum;
        for (int i = k; i < n; ++i) {
            maxRate = Math.max(maxRate, ratio.get(i).getKey());
            qualitySum -= maxHeap.poll();
            qualitySum += ratio.get(i).getValue();
            maxHeap.offer(ratio.get(i).getValue());
            res = Math.min(res, maxRate * qualitySum);
        }

        return res;
    }

    static class Pair {
        double key;
        Integer value;

        public Pair(double key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public double getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
}
