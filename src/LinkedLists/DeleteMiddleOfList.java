package LinkedLists;

public class DeleteMiddleOfList {

    public static Node deleteMiddle(Node head) {
        if (head.next == null) return null;
        Node fast = head;
        Node slow = head;

        // Double speed of Hare.
        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
