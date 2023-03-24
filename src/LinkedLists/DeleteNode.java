package LinkedLists;

public class DeleteNode {

   static class Node {
      int data;
      Node next;

      Node(int data) {
         this.data = data;
      }
   }

   /**
    * 
    * @param node - It is the node which is to be deleted
    */
   public static void deleteNode(Node node) {
      node.data = node.next.data;
      node.next = node.next.next;
   }

   public static void main(String[] args) {

   }
}
