package LinkedLists;

public class ReverseNodesInKGroups {

    public Node reverseKGroup(Node head, int k) {
        Node moving = head;
        Node temp = new Node(0);
        Node ans = null;

        while (moving != null) {
            // Storing the previous and going forward,
            int count = k - 1;
            Node prev = moving;
            while (moving != null && count > 0) {
                moving = moving.next;
                count--;
            }

            // Reversing the k nodes and attaching to temp.
            if (moving != null && count == 0) {
                Node save = moving.next;
                moving.next = null;

                Node newHead = ReverseList.reverseList(prev);
                temp.next = newHead;

                if (ans == null) ans = newHead;
                while (temp.next != null) temp = temp.next;
                moving = save;
            } else {
                temp.next = prev;
            }
        }
        return ans == null ? head : ans;
    }
}
