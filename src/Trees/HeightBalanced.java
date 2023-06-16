package Trees;

/*
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees
 * of every node never differs by more than one
 */
public class HeightBalanced {

   static class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   public static int height(Node root) {
      if (root == null)
         return 0;
      if (root.left == null && root.right == null)
         return 0;
      return 1 + Math.max(height(root.left), height(root.right));
   }

   public boolean isBalanced(Node root) {
      if (root == null)
         return true;

      int lh = height(root.left);
      if (root.left != null)
         lh++;

      int rh = height(root.right);
      if (root.right != null)
         rh++;

      int d = lh - rh;
      if (Math.abs(d) > 1)
         return false;
      return isBalanced(root.left) && isBalanced(root.right);
   }

   public static void main(String[] args) {

   }
}
