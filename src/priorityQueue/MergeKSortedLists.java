package priorityQueue;

import LinkedLists.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Important in terms of interview.
 * */
public class MergeKSortedLists {

    Node mergeKList(Node[] lists, int K) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));
        Node head = new Node(0);
        Node last = head;

        for (Node list : lists) {
            if (list != null) queue.add(list);
        }
        if (queue.isEmpty()) return null;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            last.next = curr;
            last = last.next;

            // Next Element of the element added.
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }
        return head.next;
    }
}
