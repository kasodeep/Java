package LinkedLists;

public class SegregateEvenOdd {

    public static Node divide(int N, Node head) {
        Node even = null;
        Node odd = null;

        Node tempE = null;
        Node tempO = null;

        while (head != null) {
            if (head.data % 2 == 0) {
                if (even == null) {
                    even = head;
                    tempE = head;
                } else {
                    even.next = head;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = head;
                    tempO = head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            }
            head = head.next;
        }

        if (tempE == null) {
            if (odd != null) odd.next = null;
            return tempO;
        } else {
            even.next = tempO;
            if (odd != null) odd.next = null;
            return tempE;
        }
    }
}
