package LinkedLists;

/**
 * V.IMP Question, One of the most important one.
 */
public class MergeSort {

    public static Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;

        // Mid of the list and divide into two.
        Node prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        Node list1 = sortList(head);
        Node list2 = sortList(slow);
        return merge(list1, list2);
    }

    public static Node merge(Node list1, Node list2) {
        Node l = new Node(0), p = l;

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

        if (list1 != null) p.next = list1;
        if (list2 != null) p.next = list2;
        return l.next;
    }

    public static void main(String[] args) {

    }
}
