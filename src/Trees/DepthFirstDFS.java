package Trees;

import java.util.Stack;

public class DepthFirstDFS {

   static class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
         this.val = val;
      }
   }

   /* Depth First Search algorithm, it is the same as inorder. */
   public void dfs(Node root) {
      Stack<Node> st = new Stack<>();
      st.push(root);

      while (st.size() > 0) {
         Node temp = st.peek();
         if (temp.left != null) {
            st.push(temp.left);
            temp.left = null;
         } else {
            st.pop();
            System.out.print(temp.val + " ");

            if (temp.right != null)
               st.push(temp.right);
         }
      }
   }

   public static void main(String[] args) {

   }
}
