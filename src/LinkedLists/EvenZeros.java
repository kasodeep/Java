package LinkedLists;

public class EvenZeros {
    public static Node update(Node head) {
        int count = 0;
        Node prev = null, curr = head;

        while (curr != null) {
            if (curr.data == 1) {
                if (count % 2 == 1) {
                    prev.next = new Node(0);
                    prev = prev.next;
                    prev.next = curr;
                }
                count = 0;
            } else {
                count++;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
