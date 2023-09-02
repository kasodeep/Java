package LinkedLists;

public class ZigZagList {

    static void zigZagList(Node<Integer> head) {
        int temp;
        boolean flag = true;

        Node<Integer> current = head;
        while (current != null && current.next != null) {
            if (flag) {
                if (current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            } else {
                if (current.data < current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
            current = current.next;
            flag = !(flag);
        }
    }

    public static void main(String[] args) {

    }
}
