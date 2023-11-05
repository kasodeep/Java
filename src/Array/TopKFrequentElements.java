package Array;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) mp.put(num, mp.getOrDefault(num, 0) + 1);

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (Objects.equals(mp.get(a), mp.get(b))) ? b - a : mp.get(b) - mp.get(a));
        pq.addAll(mp.keySet());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) arr[i] = pq.remove();
        return arr;
    }

    public static void main(String[] args) {

    }
}
