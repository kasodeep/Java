package DoublyLinkedList;

public class RotateListByN {

    static void rotate(Node head, int N) {
        if (N == 0) return;

        Node current = head;
        int count = 1;
        while (count < N && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        Node NthNode = current;
        while (current.next != null) current = current.next;

        // First and Last Pointer Changing.
        current.next = head;
        head.prev = current;

        head = NthNode.next;
        head.prev = null;
        NthNode.next = null;
    }
}
