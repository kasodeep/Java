package LinkedLists;

public class ReOrderList {

    public static Node<Integer> findMid(Node<Integer> head) {
        Node<Integer> slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> reverseRecursive(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void reorderList(Node<Integer> head) {
        Node<Integer> mid = findMid(head);
        Node<Integer> head2 = mid.next;
        mid.next = null;
        head2 = reverseRecursive(head2);

        Node<Integer> node = head;
        Node<Integer> temp;
        while (node != null || head2 != null) {
            if(node == null) return;

            temp = node.next;
            node.next = head2;
            node = node.next;
            head2 = temp;
        }
    }

    public static void main(String[] args) {

    }
}
