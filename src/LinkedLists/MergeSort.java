package LinkedLists;

public class MergeSort {

    public static Node<Integer> sortList(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;

        Node<Integer> prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        Node<Integer> list1 = sortList(head);
        Node<Integer> list2 = sortList(slow);
        return merge(list1, list2);
    }

    public static Node<Integer> merge(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> l = new Node<>(0), p = l;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null)
            p.next = list1;
        if (list2 != null)
            p.next = list2;
        return l.next;
    }

    public static void main(String[] args) {

    }
}
