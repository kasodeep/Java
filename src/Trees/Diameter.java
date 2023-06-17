package Trees;

public class Diameter {

   int max = 0;

   /* Function to find the Diameter of a Binary Tree.
   *  Diameter is the longest path between two nodes. It may or may not pass through root node.*/
   public int diameterOfBinaryTree(Node root) {
      solve(root);
      return max;
   }

   /* Helper function. */
   public int solve(Node root) {
      if (root == null)
         return 0;

      int left = solve(root.left);
      int right = solve(root.right);

      if (max < right + left)
         max = right + left;
      return right > left ? (right + 1) : (left + 1);
   }

   public static void main(String[] args) {

   }
}
