package LinkedLists;

public class AddTwoNumbers {

    public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        int carry = 0;
        Node<Integer> result = new Node<>(-1);
        Node<Integer> mainTemp = result;

        while (l1 != null && l2 != null) {
            int total = l1.data + l2.data + carry;
            Node<Integer> temp = new Node<>(total % 10);
            carry = total / 10;

            if (mainTemp == null) {
                mainTemp = temp;
            } else {
                mainTemp.next = temp;
                mainTemp = mainTemp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int total = l1.data + carry;
            Node<Integer> temp = new Node<>(total % 10);
            carry = total / 10;

            if (mainTemp == null) {
                mainTemp = temp;
            } else {
                mainTemp.next = temp;
                mainTemp = mainTemp.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int total = l2.data + carry;
            Node<Integer> temp = new Node<>(total % 10);
            carry = total / 10;

            if (mainTemp == null) {
                mainTemp = temp;
            } else {
                mainTemp.next = temp;
                mainTemp = mainTemp.next;
            }
            l2 = l2.next;
        }

        if (carry != 0) {
            mainTemp.next = new Node<>(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}
