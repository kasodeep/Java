package LinkedLists;

/**
 * Limitations of a Singly Linked List :
 * Get <- O(n), More space is required, Cannot access back elements.
 */
public class DoublyLL<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    // Initialization
    DoublyLL() {
        head = new Node<>(-1);
        tail = new Node<>(-1);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        DoublyLL<Integer> list = new DoublyLL<>();
        list.insertAtBegin(3);
        list.insertAtEnd(9);
        list.insertAtEnd(4);
        list.insertAtBegin(6);
        list.insertAt(3, 2);
        list.printList();
        list.deleteAt(2);
        list.printListRev();
        System.out.println(list.size);
        System.out.println(list.isPalindrome());
    }

    /**
     * @param data - It the data to be inserted in the linked list.
     */
    public void insertAtBegin(int data) {
        if (head.data == -1) {
            head.data = data;
        } else {
            Node<T> t = new Node<>(data);
            t.next = head;
            head.prev = t;
            head = t;
        }
        size++;
    }

    /**
     * @param data - It the data to be inserted in the linked list.
     */
    public void insertAtEnd(int data) {
        if (tail.data == -1) {
            tail.data = data;
        } else {
            Node<T> t = new Node<>(data);
            t.prev = tail;
            tail.next = t;
            tail = t;
        }
        size++;
    }

    /**
     * @param index - It is the place where new node is to be inserted.
     * @param data  - It is the data of the new node.
     *              Time Complexity - O(index), Space Complexity - O(1)
     */
    public void insertAt(int index, int data) {
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException("Please Enter Valid Index");

        Node<T> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node<T> add = new Node<>(data);
        add.next = temp.next;
        temp.next.prev = add;
        temp.next = add;
        add.prev = temp;
        size++;
    }

    /**
     * @param index - It is the place where the node is to be deleted.
     *              Time Complexity - O(index), Space Complexity - O(1)
     */
    public void deleteAt(int index) {
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException("Please Enter Valid Index");

        Node<T> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }

    // Function to print the List
    public void printList() {
        if (size == 0)
            return;

        if (head.next.data == -1) {
            System.out.println(head.data);
            return;
        }

        if (tail.prev.data == -1) {
            System.out.println(tail.data);
            return;
        }

        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isPalindrome() {
        Node<T> end = head;
        Node<T> start = head;
        while (end.next != null) {
            end = end.next;
        }

        while (start != end) {
            if (start.data != end.data)
                return false;
            start = start.next;
            end = end.prev;
        }
        return true;
    }

    public void printListRev() {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
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
