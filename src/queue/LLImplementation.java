package queue;

/**
 * Linked List Implementation of Queue.
 * Advantages -> size is unlimited, Works like a LL.
 */
public class LLImplementation {

   public static class Node {
      int data;
      Node next;

      Node(int data) {
         this.data = data;
      }
   }

   public static class QueueLinkedList {
      private Node head = null;
      private Node tail = null;
      int size = 0;

      // Add Function
      public void add(int x) {
         Node temp = new Node(x);
         if (size == 0) {
            head = tail = temp;
         } else {
            tail.next = temp;
            tail = temp;
         }
         size++;
      }

      // Remove Function
      public int remove() {
         if (size == 0) {
            System.out.println(("Queue is Empty"));
            return -1;
         }
         int x = head.data;
         head = head.next;
         size--;
         return x;
      }

      // Peek Function
      public int peek() {
         if (size == 0) {
            System.out.println(("Queue is Empty"));
            return -1;
         }
         return head.data;
      }

      // Function to Display
      public void display() {
         Node temp = head;
         while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
         }
         System.out.println();
      }
   }

   public static void main(String[] args) {

   }
}
