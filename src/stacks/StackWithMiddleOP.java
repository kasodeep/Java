package stacks;

public class StackWithMiddleOP {

    public static void main(String[] args) {
        myStack ms = new myStack();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);

        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : " + ms.findMiddle());
        ms.deleteMiddleElement();
        System.out.println("New Middle Element : " + ms.findMiddle());
    }

    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int data) {
            this.data = data;
        }
    }

    public static class myStack {
        DLLNode head;
        DLLNode mid;
        int size;

        /* Function to push an element to the stack */
        void push(int new_data) {
            DLLNode new_node = new DLLNode(new_data);
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
