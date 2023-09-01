package LinkedLists;

/**
 * A linked list is a linear data structure that stores data in the form of nodes that are connected to each other with the help of pointers.
 */
public class Implementation {

    public static void main(String[] args) {
        linkedList<String> list = new linkedList<>();
        list.insertAtBegin("Parth");
        list.insertAtBegin("Deep");
        list.insertAtEnd("Kesha");
        list.insertAtBegin("Shruti");
        list.insertAtEnd("Tej");

        list.insertAt(2, "Het");
        list.insertAt(0, "Dada");
        list.deleteAt(2);
        System.out.println(list.getAt(2));
        list.display();

        list.clear();
        list.add("Deep");
        list.display();
    }

    public static class linkedList<T> {

        Node<T> head = null;
        Node<T> tail = null;
        int size = 0;

        /**
         * @param data - It the data to be inserted in the linked list.
         *             O(1) - > tail is Given, O(n) -> head is Given.
         */
        void insertAtEnd(T data) {
            Node<T> temp = new Node<>(data);
            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        /**
         * @param data - It the data to be inserted in the linked list.
         *             O(n) - > tail is Given, O(1) -> head is Given.
         */
        void insertAtBegin(T data) {
            Node<T> temp = new Node<>(data);
            if (head == null) {
                tail = temp;
            } else {
                temp.next = head;
            }
            head = temp;
            size++;
        }

        /**
         * @param index - It is the place where new node is to be inserted.
         * @param data  - It is the data of the new node.
         *              Time Complexity - O(n), Space Complexity - O(1)
         */
        void insertAt(int index, T data) {
            Node<T> node = new Node<>(data);
            Node<T> temp = head;

            if (index == 0) {
                insertAtBegin(data);
                return;
            } else if (index == size) {
                insertAtEnd(data);
                return;
            } else if (index < 0) {
                throw new IndexOutOfBoundsException("Please Enter Proper Index");
            }

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }

        /**
         * Function to get the element at a particular index.
         *
         * @param index - It is the index of the element to be returned.
         */
        T getAt(int index) {
            if (index == 0) {
                return head.data;
            } else if (index == size) {
                return tail.data;
            } else if (index < 0) {
                throw new IndexOutOfBoundsException("Please Enter Valid Index.");
            }

            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        /**
         * Function to delete the node at a given index.
         *
         * @param index -  It is the index of the element to be deleted.
         */
        void deleteAt(int index) {
            if (index == 0) {
                head = head.next;
                return;
            } else if (index < 0) {
                return;
            }

            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        /**
         * Utility function to print the linkedList.
         */
        void display() {
            Node<T> temp = head;
            System.out.print("[ ");

            while (temp != null) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.println("]");
        }

        /**
         * Function to add the element at last.
         */
        void add(T data) {
            insertAtEnd(data);
        }

        /**
         * Function to reset the Linked List.
         */
        void clear() {
            head = null;
            size = 0;
        }
    }
}
