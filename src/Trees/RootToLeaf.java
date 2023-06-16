package Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {

   class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   public void helper(Node root, List<String> list, String s) {
      if (root == null)
         return;

      if (root.left == null && root.right == null) {
         s += root.val;
         list.add(s);
         return;
      }

      helper(root.left, list, s + root.val + "->");
      helper(root.right, list, s + root.val + "->");
   }

   public List<String> binaryTreePaths(Node root) {
      List<String> list = new ArrayList<>();
      helper(root, list, "");
      return list;
   }

   public static void main(String[] args) {

   }
}
