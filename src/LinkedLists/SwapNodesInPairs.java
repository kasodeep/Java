package LinkedLists;

/**
 * Good Hard Questions!
 * */
public class SwapNodesInPairs {

    public Node swapPairs(Node head) {
        Node curr = head;
        Node ans = head;
        Node prev = null;

        // New Head Initialization!
        if (curr != null && curr.next != null) ans = curr.next;

        while (curr != null && curr.next != null) {
            Node temp = curr.next;
            curr.next = temp.next;

            if (prev != null) {
                prev.next = temp;
            }
            prev = curr;
            temp.next = curr;
            curr = curr.next;
        }
        return ans;
    }
}
