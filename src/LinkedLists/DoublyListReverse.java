package LinkedLists;

public class DoublyListReverse {

    public static Node<Integer> reverseDLL(Node<Integer> head) {
        Node<Integer> temp = null;
        Node<Integer> current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null)
            head = temp.prev;
        return head;
    }

    public static void main(String[] args) {

    }

    static class Node<T> {
        int data;
        Node<T> next;
        Node<T> prev;

        Node(int data) {
            this.data = data;
        }
    }
}
