package LinkedLists;

public class ReOrderList {

    public static Node findMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void reorderList(Node head) {
        Node mid = findMid(head);
        Node head2 = mid.next;

        mid.next = null;
        head2 = reverseRecursive(head2);

        Node node = head, temp;
        while (node != null || head2 != null) {
            if (node == null) return;

            temp = node.next;
            node.next = head2;
            node = node.next;
            // Remember this Swap!
            head2 = temp;
        }
    }

    public static void main(String[] args) {

    }
}
