package DoublyLinkedList;

public class DoublyPairSum {

    static void pairSum(Node head, int x) {
        Node first = head;
        Node second = head;
        while (second.next != null) second = second.next;

        boolean found = false;
        while (first != second && second.next != first) {
            if (first.data + second.data == x) {
                found = true;
                first = first.next;
                second = second.prev;
            } else {
                if (first.data + second.data < x) first = first.next;
                else second = second.prev;
            }
        }

        if (!found) System.out.println("No pair found!");
    }
}
