package LinkedLists;


public class ListWithRandomPointer {

    public static ListNode copyRandomList(ListNode head) {
        ListNode head2 = new ListNode(0);
        ListNode temp2 = head2;
        ListNode temp1 = head;

        // Creating Deep Copy.
        while (temp1 != null) {
            temp2.next = new ListNode(temp1.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        head2 = head2.next;
        temp2 = head2;
        temp1 = head;
        ListNode temp = new ListNode(-1);

        // Alternate Connections.
        while (temp1 != null) {
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }

        temp2 = head2;
        temp1 = head;

        // Assigning Random Pointers.
        while (temp1 != null && temp2 != null) {
            if (temp1.random == null) temp2.random = null;
            else temp2.random = temp1.random.next;
            temp1 = temp2.next;
            if (temp1 != null) temp2 = temp1.next;
        }

        temp2 = head2;
        temp1 = head;

        // Separating Between the Lines.
        while (temp1 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;

            if (temp1 == null) break;
            temp2.next = temp1.next;
            if (temp2.next == null) break;
            temp2 = temp2.next;
        }
        return head2;
    }

    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
