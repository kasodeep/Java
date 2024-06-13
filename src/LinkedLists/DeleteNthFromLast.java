package LinkedLists;

public class DeleteNthFromLast {

    /**
     * Let l be the size of the list.
     * If fast moves n steps first, it is at l - n steps from the end.
     * Now when both the pointers move, the slow travels l - n steps and hence.
     * */
    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;

        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
