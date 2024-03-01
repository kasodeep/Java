package LinkedLists;

public class ReverseList {

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node agla;

        while (curr != null) {
            agla = curr.next;

            // Changing the direction.
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
