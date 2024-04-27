package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Very Important Question For Interview.
 * */
public class MedianStream {

    private static final PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private static final PriorityQueue<Integer> large = new PriorityQueue<>();
    private static boolean even = true;

    //Function to insert heap.
    public static void insertHeap(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    //Function to return Median.
    public static double getMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}
