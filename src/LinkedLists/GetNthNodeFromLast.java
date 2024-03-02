package LinkedLists;

public class GetNthNodeFromLast {

    static int getNthFromLast(Node head, int n) {
        Node temp = head;
        int l = 0;

        while (head != null) {
            head = head.next;
            l++;
        }

        if (n > l) return -1;
        int c = l - n;

        while (temp != null && c-- > 0) temp = temp.next;
        return temp == null ? -1 : temp.data;
    }
}
