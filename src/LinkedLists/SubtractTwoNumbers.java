package LinkedLists;

public class SubtractTwoNumbers {

    static Node<Integer> removeLeadingZeros(Node<Integer> a) {
        if (a != null && a.data == 0) return removeLeadingZeros(a.next);
        else return a;
    }

    static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> prev = null, curr = head, agla;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;

            prev = curr;
            curr = agla;
        }
        return prev;
    }

    static int length(Node<Integer> head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static Node<Integer> findLarger(Node<Integer> l1, int len1, Node<Integer> l2, int len2) {
        Node<Integer> temp1 = l1;
        Node<Integer> temp2 = l2;

        if (len1 < len2) {
            temp1 = l2;
            temp2 = l1;
        } else {
            while (temp1 != null && temp2 != null) {
                if (temp1.data > temp2.data) {
                    temp1 = l1;
                    temp2 = l2;
                    break;
                } else if (temp1.data < temp2.data) {
                    temp1 = l2;
                    temp2 = l1;
                    break;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            if (temp1 == null && temp2 == null) return new Node<>(0);
        }
        return subtract(temp1, temp2);
    }

    static Node<Integer> subtract(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> l1 = n1;
        Node<Integer> l2 = n2;

        l1 = reverse(l1);
        l2 = reverse(l2);

        Node<Integer> res = new Node<>(-1);
        Node<Integer> temp = res;

        int borrow = 0;
        int diff;

        while (l1 != null) {
            diff = borrow + l1.data - ((l2 != null) ? l2.data : 0);

            if (diff < 0) {
                borrow = -1;
                diff = 10 + diff;
            } else {
                borrow = 0;
            }

            temp.next = new Node<>(diff);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        res = reverse(res.next);
        res = removeLeadingZeros(res);
        return res;
    }

    static Node<Integer> subLinkedList(Node<Integer> l1, Node<Integer> l2) {
        l1 = removeLeadingZeros(l1);
        l2 = removeLeadingZeros(l2);

        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 == 1 && l1.data == 0) return l2;
        if (len2 == 1 && l2.data == 0) return l1;

        return findLarger(l1, len1, l2, len2);
    }
}
