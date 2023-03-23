package LinkedLists;

// Types of Linked List : -> Singly, Doubly, Circular.
public class Implementation {

   // Node Class
   public static class Node {
      int data;
      Node next;

      Node(int data) {
         this.data = data;
      }
   }

   public static class linkedlist {

      Node head = null;
      Node tail = null;
      int size = 0;

      // Function to add the element at the last of the list.
      // O(1) - > tail is Given, O(n) -> head is Given.
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

      // Function to add the element at the beginning.
      // O(1) -> head is Given, O(n) -> tail is Given.
      void insertAtBegin(int data) {

         Node temp = new Node(data);
         if (head == null) {
            head = tail = temp;
         } else {
            temp.next = head;
         }
         head = temp;
         size++;
      }

      /**
       * 
       * @param index - It is the place where new node is to be inserted.
       * @param data  - It is the data of the new node.
       *              Time Complexiy - O(n), Space Complexity - O(1)
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
            return;
         }

         for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
         }
         node.next = temp.next;
         temp.next = node;
         size++;
      }

      // Function to get the element at a particular index
      int getAt(int index) {

         if (index == 0) {
            return head.data;
         } else if (index == size) {
            return tail.data;
         } else if (index < 0) {
            return -1;
         }

         Node temp = head;
         for (int i = 0; i < index; i++) {
            temp = temp.next;
         }

         return temp.data;
      }

      // Function to delet a node at index.
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

      // Utility function to print the linkedlist.
      void display() {
         Node temp = head;
         while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
         }
         System.out.println();
      }

   }

   public static void main(String[] args) {

      // 5 -> 10 -> 20 -> 25 -> 30 -> 40
      linkedlist ll = new linkedlist();
      ll.insertAtBegin(20);
      ll.insertAtEnd(30);
      ll.insertAtBegin(10);
      ll.insertAtEnd(40);
      ll.insertAt(2, 25);
      ll.insertAt(0, 5);
      ll.deleteAt(2);
      System.out.println(ll.getAt(2));
      ll.display();

   }
}
