package BinarySearchTrees;

/**
 * Important Conditions for binary trees ->.
 * In Binary Search Trees every node to the left of the given node is smaller than the node.
 * In Binary Search Trees every node to the right of the given node is larger than the node.
 */
public class Basics {

    /**
     * Inorder always prints the sorted values. Important!!
     * @param root - It is the root of the binary tree to do traversal.
     */
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /**
     * Advantages : Efficient Searching O(logn)
     * Efficient Insertion and Deletion
     * Usage in TreeMaps, PriorityQueues.
     * */
    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89", "10", "", "28", "", "", "", "70", "", "", "14"};
        Node root = Construct.construct(arr);
        inorder(root);
    }
}
