package stacks;

// DiaAdv : two data members, more space / space complexity is higher for display
// Adv : unlimited size
public class LLImplementation {

   public static class Node {
      int data;
      Node next;

      Node(int data) {
         this.data = data;
      }
   }

   public static class LLStack {
      Node head = null;
      int size = 0;

      void push(int x) {
         Node temp = new Node(x);
         temp.next = head;
         head = temp;
         size++;
      }

      int pop() {
         if (head == null) {
            System.out.println("Stack is Empty");
            return -1;
         }
         int x = head.data;
         head = head.next;
         return x;
      }

      int peek() {
         if (head == null) {
            System.out.println("Stack is Empty");
            return -1;
         }
         return head.data;
      }

      void displayRec(Node h) {
         if (h == null)
            return;
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

   public static void main(String[] args) {

   }
}
