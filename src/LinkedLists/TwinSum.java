package LinkedLists;

import static LinkedLists.ReverseList.reverseList;

public class TwinSum {

    public static int pairSum(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node<Integer> half = reverseList(slow.next);
        Node<Integer> temp1 = head;
        Node<Integer> temp2 = half;
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
