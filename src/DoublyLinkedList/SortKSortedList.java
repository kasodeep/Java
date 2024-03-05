package DoublyLinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * One of the important and hard questions!
 */
public class SortKSortedList {

    public static Node sortedDll(Node head, int k) {
        if (head == null) return head;

        PriorityQueue<Node> pq = new PriorityQueue<>(new MyComparator());
        Node newHead = null, last = null;

        for (int i = 0; head != null && i <= k; i++) {
            pq.add(head);
            head = head.next;
        }

        while (!pq.isEmpty()) {
            if (newHead == null) {
                newHead = pq.peek();
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = pq.peek();
                pq.peek().prev = last;
                last = pq.peek();
            }

            pq.poll();
            if (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        if (last != null) last.next = null;
        return newHead;
    }

    static class MyComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return n1.data - n2.data;
        }
    }
}
