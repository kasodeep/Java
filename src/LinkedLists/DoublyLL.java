package LinkedLists;

// Limitations of a Singly Linked List :
// Get <- O(n), More space is required, Cannot access back elements.
public class DoublyLL {

   Node head;
   Node tail;
   int size;

   class Node {
      int data;
      Node next;
      Node prev;

      Node(int data) {
         this.data = data;
      }
   }

   DoublyLL() {
      head = new Node(-1);
      tail = new Node(-1);
      size = 0;
      head.next = tail;
      tail.prev = head;
   }

   public void insertAtBegin(int data) {

      if (head.data == -1) {
         head.data = data;
      } else {
         Node t = new Node(data);
         t.next = head;
         head.prev = t;
         head = t;
      }
      size++;
   }

   public void insertAtEnd(int data) {

      if (tail.data == -1) {
         tail.data = data;
      } else {
         Node t = new Node(data);
         t.prev = tail;
         tail.next = t;
         tail = t;
      }
      size++;
   }

   /**
    * 
    * @param index - It is the place where new node is to be inserted.
    * @param data  - It is the data of the new node.
    *              Time Complexiy - O(index), Space Complexity - O(1)
    */
   public void insertAt(int index, int data) {

      if (size < index || index < 0)
         return;

      Node temp = head;
      for (int i = 1; i < index; i++) {
         temp = temp.next;
      }
      Node add = new Node(data);
      add.next = temp.next;
      temp.next.prev = add;
      temp.next = add;
      add.prev = temp;
      size++;
   }

   public void deleteAt(int index) {

      if (size < index || index < 0)
         return;

      Node temp = head;
      for (int i = 1; i < index; i++) {
         temp = temp.next;
      }
      temp.next = temp.next.next;
      temp.next.prev = temp;
      size--;
   }

   // Function to print the List
   public void printList() {

      if (size == 0)
         return;

      if (head.next.data == -1) {
         System.out.println(head.data);
         return;
      }

      if (tail.prev.data == -1) {
         System.out.println(tail.data);
         return;
      }

      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.next;
      }
      System.out.println();
   }

   public boolean isPalindrome() {
      Node end = head;
      Node start = head;
      while (end.next != null) {
         end = end.next;
      }

      while (start != end) {
         if (start.data != end.data)
            return false;
         start = start.next;
         end = end.prev;
      }

      return true;
   }

   // Function to print rev if only head is given
   public void printListRev() {
      Node temp = head;
      while (temp.next != null) {
         temp = temp.next;
      }

      while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.prev;
      }
      System.out.println();
   }

   public static void main(String[] args) {
      DoublyLL list = new DoublyLL();
      list.insertAtBegin(3);
      list.insertAtEnd(9);
      list.insertAtEnd(4);
      list.insertAtBegin(6);
      list.insertAt(3, 2);
      list.printList();
      // list.deleteAt(2);
      // list.printListRev();
      System.out.println(list.size);
      System.out.println(list.isPalindrome());
   }
}
