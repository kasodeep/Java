package Trees;

public class Diameter {

   int max = 0;

   class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   public int diameterOfBinaryTree(Node root) {
      solve(root);
      return max;
   }

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
