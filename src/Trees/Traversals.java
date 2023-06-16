package Trees;

/*
 * Travelling each anf every element atleast once.
 */
public class Traversals {

   static class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   /*
    * To do preorder traversal that is work -> left -> right.
    */
   public static void preorder(Node root) {
      if (root == null)
         return;
      System.out.print(root.val + " ");
      preorder(root.left);
      preorder(root.right);
   }

   /*
    * To do inorder traversal that is left -> work -> right.
    */
   public static void inorder(Node root) {
      if (root == null)
         return;
      inorder(root.left);
      System.out.print(root.val + " ");
      inorder(root.right);
   }

   /*
    * To do postorder traversal that is left -> right -> work.
    */
   public static void postorder(Node root) {
      if (root == null)
         return;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.val + " ");
   }

   public static void main(String[] args) {
      // Creating a Binary Tree to display values and do traversals.
      Node root = new Node(10);
      Node a = new Node(20);
      Node b = new Node(30);
      root.left = a;
      root.right = b;

      Node c = new Node(40);
      Node d = new Node(50);
      a.left = c;
      a.right = d;

      Node e = new Node(60);
      Node f = new Node(70);
      b.right = e;
      e.right = f;

      preorder(root);
      System.out.println();
      inorder(root);
      System.out.println();
      postorder(root);
   }
}
