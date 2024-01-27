package Stacks;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * Adv : size or space taken is less / display is better.
 * DisAdv : fixed size / overflow
 */
public class ArrayImplementation {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(Integer.class);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }

    public static class Stack<T> {
        private final T[] arr;
        private int currentIndex;

        /**
         * Creates stack of default size 5.
         */
        @SuppressWarnings("unchecked")
        Stack(Class<T> clazz) {
            arr = (T[]) Array.newInstance(clazz, 5);
            currentIndex = 0;
        }

        @SuppressWarnings("unchecked")
        Stack(Class<T> clazz, int size) {
            arr = (T[]) Array.newInstance(clazz, size);
            currentIndex = 0;
        }

        void push(T x) {
            if (isFull()) {
                throw new IndexOutOfBoundsException("Stack is Full");
            }
            arr[currentIndex] = x;
            currentIndex++;
        }

        T peek() {
            if (currentIndex == 0) {
                throw new EmptyStackException();
            }
            return arr[currentIndex - 1];
        }

        T pop() {
            if (currentIndex == 0) {
                throw new EmptyStackException();
            }
            T top = arr[currentIndex - 1];
            currentIndex--;
            return top;
        }

        void display() {
            for (T num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int size() {
            return currentIndex;
        }

        boolean isEmpty() {
            return currentIndex == 0;
        }

        boolean isFull() {
            return currentIndex == arr.length;
        }

        int capacity() {
            return arr.length;
        }
    }
}
