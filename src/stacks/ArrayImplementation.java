package stacks;

// Adv : size or space taken is less / display is better 
// DisAdv : fixed size / overflow
public class ArrayImplementation {

   public static class Stack {
      private int[] arr;
      private int idx;

      // We can also set our own size without user input.
      Stack(int size) {
         arr = new int[size];
         idx = 0;
      }

      void push(int x) {
         if (isFull()) {
            System.out.println("Stakc is Full!");
            return;
         }
         arr[idx] = x;
         idx++;
      }

      int peek() {
         if (idx == 0) {
            System.out.println("Stack is Empty");
            return -1;
         }
         return arr[idx - 1];
      }

      int pop() {
         if (idx == 0) {
            System.out.println("Stack is Empty");
            return -1;
         }
         int top = arr[idx - 1];
         arr[idx - 1] = 0;
         idx--;
         return top;
      }

      void display() {
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
         }
         System.out.println();
      }

      int size() {
         return idx;
      }

      boolean isEmpty() {
         if (idx == 0)
            return true;
         return false;
      }

      boolean isFull() {
         if (idx == arr.length)
            return true;
         return false;
      }

      int capacity() {
         return arr.length;
      }
   }

   public static void main(String[] args) {

   }
}
