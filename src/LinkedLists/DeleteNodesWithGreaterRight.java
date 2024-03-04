package LinkedLists;

public class DeleteNodesWithGreaterRight {

    public static Node compute(Node head) {
        head = ReverseList.reverseList(head);
        Node pre = null;
        Node crr = head;

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
        return ReverseList.reverseList(head);
    }

    public static void main(String[] args) {

    }
}
