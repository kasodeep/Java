package LinkedLists;

/**
 * A linked list is a linear data structure that stores data in the form of nodes that are connected to each other with the help of pointers.
 */
public class Implementation {

    static class MyLinkedList {

        Node head;
        Node tail;
        int size;

        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            } else if (index == 0) {
                return head.data;
            } else if (index == size - 1) {
                return tail.data;
            }

            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        public void addAtHead(int data) {
            Node temp = new Node(data);
            if (head == null) {
                tail = temp;
            } else {
                temp.next = head;
            }
            head = temp;
            size++;
        }

        public void addAtTail(int data) {
            Node temp = new Node(data);
            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        public void addAtIndex(int index, int data) {
            if (index < 0 || index > size) return;

            Node node = new Node(data);
            Node temp = head;

            if (index == 0) {
                addAtHead(data);
                return;
            } else if (index == size) {
                addAtTail(data);
                return;
            }

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            } else if (index == 0) {
                head = head.next;
                size--;
                return;
            }

            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            if (index == size - 1) {
                temp.next = null;
                tail = temp;
            } else {
                temp.next = temp.next.next;
            }
            size--;
        }
    }
}
