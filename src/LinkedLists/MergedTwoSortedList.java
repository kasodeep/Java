package LinkedLists;

public class MergedTwoSortedList {

    public static Node mergeTwoLists(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 == null) temp.next = head2;
        else temp.next = head1;

        return merged.next;
    }

    public static void main(String[] args) {

    }
}
