package LinkedLists;

/**
 * A linked list is a linear data structure that stores data in the form of nodes that are connected to each other with the help of pointers.
 */
public class Implementation {

    public static class linkedList {

        Node head = null;
        Node tail = null;
        int size = 0;

        /**
         * @param data - It the data to be inserted in the linked list.
         *             O(1) - > tail is Given, O(n) -> head is Given.
         */
        void insertAtEnd(int data) {
            Node temp = new Node(data);
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
        void insertAtBegin(int data) {
            Node temp = new Node(data);
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
        void insertAt(int index, int data) {
            Node node = new Node(data);
            Node temp = head;

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
        int getAt(int index) {
            if (index == 0) {
                return head.data;
            } else if (index == size) {
                return tail.data;
            } else if (index < 0) {
                throw new IndexOutOfBoundsException("Please Enter Valid Index.");
            }

            Node temp = head;
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

            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        /**
         * Utility function to print the linkedList.
         */
        void display() {
            Node temp = head;
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
        void add(int data) {
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
