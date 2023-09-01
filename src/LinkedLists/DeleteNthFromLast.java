package LinkedLists;

public class DeleteNthFromLast {

    public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
        if (head == null) return null;

        Node<Integer> fast = head;
        Node<Integer> slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // For n = 1, and list.size() == 1
        if (fast == null) {
            return head.next;
        }

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
