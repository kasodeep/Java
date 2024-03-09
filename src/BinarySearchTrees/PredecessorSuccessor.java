package BinarySearchTrees;

/**
 * In a Binary Search Tree (BST), the inorder predecessor of a node is the node with the largest value smaller than
 * the given node, and the inorder successor of a node is the node with the smallest value larger than the given node.
 * If key is not present then print the range between which the given key lies in the bst, otherwise print -1.
 */
public class PredecessorSuccessor {
    public static void findPreSuc(Node root, int key, Node[] preSuc) {
        if (root == null)
            return;

        if (root.val == key) {
            if (root.left != null) {
                Node pre = root.left;
                while (pre.right != null) pre = pre.right;
                preSuc[0] = pre;
            }

            if (root.right != null) {
                Node suc = root.right;
                while (suc.left != null) suc = suc.left;
                preSuc[1] = suc;
            }
            return;
        }

        if (root.val > key) {
            preSuc[1] = root; // In case key is absent.
            findPreSuc(root.left, key, preSuc);
        } else {
            preSuc[0] = root;
            findPreSuc(root.right, key, preSuc);
        }
    }
}
