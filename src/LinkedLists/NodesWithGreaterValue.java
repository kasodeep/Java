package LinkedLists;

public class NodesWithGreaterValue {

    public static Node<Integer> reverse(Node<Integer> node) {
        Node<Integer> pre = null;
        while (node != null) {
            Node<Integer> next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static Node<Integer> compute(Node<Integer> head) {
        head = reverse(head);
        Node<Integer> pre = null;
        Node<Integer> crr = head;

        int flag = Integer.MIN_VALUE;
        while (crr != null) {
            if (crr.data < flag) {
                pre.next = crr.next;
                crr = crr.next;
                continue;
            }
            flag = crr.data;
            pre = crr;
            crr = crr.next;
        }
        return reverse(head);
    }

    public static void main(String[] args) {

    }
}
