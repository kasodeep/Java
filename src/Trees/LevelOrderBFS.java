package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBFS {

   static class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   /*
    * Breadth First Search algorithm to find and print the elements in level order.
    */
   public static void bfs(Node root) {
      Queue<Node> q = new LinkedList<>();
      if (root != null)
         q.add(root);

      while (q.size() > 0) {
         Node temp = q.peek();

         if (temp.left != null)
            q.add(temp.left);
         if (temp.right != null)
            q.add(temp.right);

         System.out.print(temp.val + " ");
         q.remove();
      }
   }

   public static void main(String[] args) {

   }
}
