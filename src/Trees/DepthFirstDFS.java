package Trees;

import java.util.Stack;

public class DepthFirstDFS {

    /* Depth First Search algorithm, it is the same as inorder. */
    public static void dfs(Node root) {
        Stack<Node> st = new Stack<>();
        if (root != null)
            st.push(root);

        while (st.size() > 0) {
            Node temp = st.peek();

            /* If there is a left part add it to the stack and de-attach it. */
            if (temp.left != null) {
                st.push(temp.left);
                temp.left = null; /* Very Important Step */
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
