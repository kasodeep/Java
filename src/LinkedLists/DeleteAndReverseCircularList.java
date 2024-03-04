package LinkedLists;

public class DeleteAndReverseCircularList {

    public static Node deleteNode(Node head, int d) {
        Node temp = head;
        Node prev = null;

        while (head.data != d) {
            prev = head;
            head = head.next;
        }

        if (prev != null) {
            prev.next = head.next;
            return temp;
        } else {
            // Head would not have progressed if prev == null.
            while (temp.next != head) temp = temp.next;
            temp.next = head.next;
            return head.next;
        }
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node agla;

        while (curr != null) {
            if (curr.next == head) {
                curr.next = prev;
                head.next = curr;
                return curr;
            }
            agla = curr.next;

            // Changing the direction.
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return null;
    }
}
