package LinkedLists;

public class SwapNodes {

    public static Node swapNodes(Node head, int k) {
        Node x = head, y = head, t = head;

        while (k > 1) {
            x = x.next;
            t = t.next;
            k--;
        }

        while (t.next != null) {
            y = y.next;
            t = t.next;
        }

        int temp = x.data;
        x.data = y.data;
        y.data = temp;
        return head;
    }

    public static void main(String[] args) {

    }
}
