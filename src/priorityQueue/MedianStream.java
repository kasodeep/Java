package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Very Important Question For Interview.
 * Another Solution on Leet-Code.
 * */
public class MedianStream {

    private static void add(PriorityQueue<Integer> leftPq, PriorityQueue<Integer> rightPq, int element) {
        if (leftPq.isEmpty()) {
            leftPq.add(element);
            return;
        }

        if (element < leftPq.peek()) {
            if (leftPq.size() == rightPq.size()) {
                leftPq.add(element);
            } else {
                rightPq.add(leftPq.remove());
                leftPq.add(element);
            }
        } else {
            if (rightPq.size() == leftPq.size()) {
                leftPq.add(rightPq.remove());
                rightPq.add(element);
            } else {
                rightPq.add(element);
            }
        }
    }

    private static double median(PriorityQueue<Integer> leftPq, PriorityQueue<Integer> rightPq) {
        if (leftPq.isEmpty()) return -1;

        if (leftPq.size() == rightPq.size()) {
            return (double) (leftPq.peek() + rightPq.peek()) / 2;
        } else {
            return leftPq.peek();
        }
    }

    // Time Complexity - O(logN), Auxiliary Space - O(N)
    public static void main(String[] args) {
        PriorityQueue<Integer> leftPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();

        add(leftPq, rightPq, 15);
        add(leftPq, rightPq, 12);
        System.out.println(median(leftPq, rightPq));

        add(leftPq, rightPq, 17);
        add(leftPq, rightPq, 20);
        System.out.println(median(leftPq, rightPq));

        add(leftPq, rightPq, 25);
        System.out.println(median(leftPq, rightPq));
    }
}
