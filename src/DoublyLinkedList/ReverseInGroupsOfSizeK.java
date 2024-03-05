package DoublyLinkedList;

/**
 * V. Important Question.
 * */
public class ReverseInGroupsOfSizeK {

    static Node revListInGroupOfGivenSize(Node head, int k) {
        if (head == null) return head;

        Node st = head;
        Node tail = null;
        Node ans = null;

        while (st != null) {
            int count = 1;
            Node curr = st;
            Node prev = null;
            Node next;

            // Reversing the k nodes.
            while (curr != null && count <= k) {
                next = curr.next;
                curr.prev = next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if (ans == null) {
                ans = prev;
                ans.prev = null;
            }

            if (tail != null) {
                tail.next = prev;
                prev.prev = tail;
            }
            tail = st;
            st = curr;
        }
        return ans;
    }
}
