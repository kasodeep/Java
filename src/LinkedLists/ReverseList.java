package LinkedLists;

public class ReverseList {

    public static Node<Integer> reverseList(Node<Integer> head) {
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> agla;

        while (curr != null) {
            agla = curr.next;

            // Changing the direction
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
