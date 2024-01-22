package stacks;

public class StackWithMiddleOP {

    public static void main(String[] args) {
        
    }

    /**
     * Static Class Node.
     * */
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class myStack {
        Node head;
        Node mid;
        int size;

        /* Function to push an element to the stack */
        void push(int new_data) {
            Node new_node = new Node(new_data);
            if (size == 0) {
                head = new_node;
                mid = new_node;
                size++;
                return;
            }

            head.next = new_node;
            new_node.prev = head;
            head = head.next;

            if (size % 2 != 0) {
                mid = mid.next;
            }
            size++;
        }

        /* Function to pop an element from stack */
        int pop() {
            int data = -1;
            if (size == 0) {
                System.out.println("Stack is empty");
            }

            if (size != 0) {
                data = head.data;
                if (size == 1) {
                    head = null;
                    mid = null;
                } else {
                    head = head.prev;
                    head.next = null;
                    if (size % 2 == 0) {
                        mid = mid.prev;
                    }
                }
                size--;
            }
            return data;
        }

        // Function for finding middle of the stack
        int findMiddle() {
            if (size == 0) {
                System.out.println("Stack is empty now");
                return -1;
            }
            return mid.data;
        }

        void deleteMiddleElement() {
            if (size != 0) {
                if (size == 1) {
                    head = null;
                    mid = null;
                } else if (size == 2) {
                    head = head.prev;
                    mid = mid.prev;
                    head.next = null;
                } else {
                    mid.next.prev = mid.prev;
                    mid.prev.next = mid.next;
                    if (size % 2 == 0) {
                        mid = mid.prev;
                    } else {
                        mid = mid.next;
                    }
                }
                size--;
            }
        }
    }
}
