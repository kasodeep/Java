package Trees;

/*
 * Every tree has a node, it has a left subtree and a right subtree.
 * 1) Leaf Node: No children
 * 2) Internal Node: !leaf and !root
 * 3) Ancestor Node: Parent and Parent's parent
 * 4) Descendant Node: Child and Child's child
 * 
 * 5) Size: No of nodes in the tree
 * 6) Edges: Size - 1
 * 7) Level: The depth of the tree is known as level
 * 8) Heigth Level - 1
 */
public class Basics {

   static class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   /*
    * Function to find the height of a binary tree.
    * Check the base case of a leaf node.
    */
   public static int height(Node root) {
      if (root == null)
         return 0;
      if (root.left == null && root.right == null)
         return 0;
      return 1 + Math.max(height(root.left), height(root.right));
   }

   /*
    * Function to find the size of a binary tree.
    */
   public static int size(Node root) {
      if (root == null)
         return 0;
      return 1 + size(root.left) + size(root.right);
   }

   /*
    * Sum of the value of all the nodes of a binary tree.
    */
   public static int sum(Node root) {
      if (root == null)
         return 0;
      return root.val + sum(root.left) + sum(root.right);
   }

   /*
    * Product of the value of all the nodes of a binary tree.
    */
   public static int product(Node root) {
      if (root == null)
         return 1;
      return root.val * sum(root.left) * sum(root.right);
   }

   /*
    * Function to find the max value of a binary tree.
    */
   public static int max(Node root) {
      if (root == null)
         return Integer.MIN_VALUE;
      return Math.max(root.val, Math.max(max(root.left), max(root.right)));
   }

   public static void main(String[] args) {
      // Creating a Binary Tree .
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

      System.out.println(max(root));
      System.out.println(size(root));
      System.out.println(sum(root));
      System.out.println(height(root));
      System.out.println(product(root));
   }
}
