package LinkedLists;

import static LinkedLists.ReverseList.reverseList;

public class TwinSum {

    public static int pairSum(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node half = reverseList(slow.next);
        Node temp1 = head;
        Node temp2 = half;
        int ans = 0;

        while (temp2 != null) {
            if (temp1.data + temp2.data > ans) {
                ans = temp1.data + temp2.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
