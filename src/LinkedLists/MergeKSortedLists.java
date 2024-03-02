package LinkedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        // Contains the head nodes of all the list.
        Node[] lists = new Node[4];
        Node head = mergeKLists(lists);
    }

    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        int K = lists.length;

        Node head = new Node(0);
        Node last = head;

        for (Node list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        if (queue.isEmpty())
            return null;
        while (!queue.isEmpty()) {

            // Smallest Element Is Added To List.
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

    static class NodeComparator implements Comparator<Node> {
        public int compare(Node k1, Node k2) {
            if (k1.data > k2.data)
                return 1;
            else if (k1.data < k2.data)
                return -1;
            return 0;
        }
    }
}
