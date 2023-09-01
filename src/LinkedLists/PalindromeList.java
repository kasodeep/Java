package LinkedLists;

import java.util.Objects;

import static LinkedLists.ReverseList.reverseList;

public class PalindromeList {

    public static boolean isPalindrome(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node<Integer> half = reverseList(slow.next);
        Node<Integer> temp1 = head;
        Node<Integer> temp2 = half;

        while (temp2 != null) {
            if (!Objects.equals(temp1.data, temp2.data)) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
