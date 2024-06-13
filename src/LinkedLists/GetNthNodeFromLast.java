package LinkedLists;

public class GetNthNodeFromLast {

    static int getNthFromLast(Node head, int n) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.data;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.next.data;
    }
}
