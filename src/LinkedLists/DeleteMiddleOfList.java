package LinkedLists;

public class DeleteMiddleOfList {

    public static Node<Integer> deleteMiddle(Node<Integer> head) {
        if (head.next == null) return null;
        Node<Integer> fast = head;
        Node<Integer> slow = head;

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
