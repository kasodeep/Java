package LinkedLists;

public class FlattenWithNextAndChild {

    public static void flattenList(Node node) {
        if (node == null) return;
        Node tmp;

        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node cur = node;
        while (cur != tail) {
            if (cur.child != null) {
                tail.next = cur.child;
                tmp = cur.child;

                // The child of child pointers will be settled later.
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

    }

    static class Node {

        int data;
        Node next, child;

        Node(int d) {
            data = d;
        }
    }
}
