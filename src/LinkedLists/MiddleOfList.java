package LinkedLists;

public class MiddleOfList {

    public static Node<Integer> middleNode(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
