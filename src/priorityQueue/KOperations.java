package priorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KOperations {

    // Time Complexity - O(N * logN), Auxiliary Space - O(N)
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {2, 4, 3, 1, 5};
        ArrayList<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        for (int i = 0; i < k; i++) {
            int f = pq.remove();
            int s = pq.remove();
            pq.add(f * s);
        }

        while(pq.size() != 1){
            pq.remove();
        }
        System.out.println(pq.peek());
    }
}
