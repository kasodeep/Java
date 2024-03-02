package LinkedLists;

public class AddTwoNumbers {

    /**
     * When the numbers are already reversed.
     */
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node head = new Node(0);
        Node l3 = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1_data = (l1 != null) ? l1.data : 0;
            int l2_data = (l2 != null) ? l2.data : 0;

            int currentSum = l1_data + l2_data + carry;
            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            l3.next = new Node(lastDigit);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if (carry > 0) l3.next = new Node(carry);
        return head.next;
    }

    /**
     * The two lists have numbers in correct order.
     */
    static Node addTwoLists(Node first, Node second) {
        Node l1 = ReverseList.reverseList(first);
        Node l2 = ReverseList.reverseList(second);

        Node head = new Node(0);
        Node l3 = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1_data = (l1 != null) ? l1.data : 0;
            int l2_data = (l2 != null) ? l2.data : 0;

            int currentSum = l1_data + l2_data + carry;
            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            l3.next = new Node(lastDigit);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if (carry > 0) l3.next = new Node(carry);
        return ReverseList.reverseList(head.next);
    }
}
