package DoublyLinkedList;

public class DoublyListReverse {

    public static Node reverseDLL(Node head) {
        if (head == null) return null;

        Node curr = head;
        Node before = null;
        Node after;

        while (curr != null) {
            after = curr.next;
            curr.next = before;
            curr.prev = after;
            before = curr;
            curr = after;
        }

        return before;
    }
}
