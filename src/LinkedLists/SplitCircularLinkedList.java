package LinkedLists;

public class SplitCircularLinkedList {

    static void splitList(circular_LinkedList list) {
        Node head1 = list.head;
        Node slow = head1;
        Node fast = head1;

        // Find the mid.
        while (fast.next != head1 && fast.next.next != head1) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Making the list themselves circular.
        Node head2 = slow.next;
        slow.next = head1;

        if (fast.next == head1) fast.next = head2;
        else fast.next.next = head2;

        list.head1 = head1;
        list.head2 = head2;
    }

    static class circular_LinkedList {
        Node head;
        Node head1;
        Node head2;
    }
}
