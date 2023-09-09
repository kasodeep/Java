package stacks;

import java.util.EmptyStackException;

/**
 * DiaAdv : Two data members, more space / time complexity is higher for display.
 * Adv : Unlimited size.
 */
public class LLImplementation {

    public static void main(String[] args) {
        LLStack<String> stack = new LLStack<>();
        stack.push("John");
        stack.push("Roman");
        stack.push("Brock");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public static class LLStack<T> {
        Node<T> head = null;
        int size = 0;

        void push(T x) {
            Node<T> temp = new Node<>(x);
            temp.next = head;
            head = temp;
            size++;
        }

        T pop() {
            if (head == null) {
                throw new EmptyStackException();
            }
            T x = head.data;
            head = head.next;
            return x;
        }

        T peek() {
            if (head == null) {
                throw new EmptyStackException();
            }
            return head.data;
        }

        private void displayRec(Node<T> h) {
            if (h == null) return;
            displayRec(h.next);
            System.out.print(h.data + " ");
        }

        void display() {
            displayRec(head);
            System.out.println();
        }

        int size() {
            return size;
        }

    }
}
