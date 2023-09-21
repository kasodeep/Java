package BinarySearchTrees;

public class MergeTwoBSTs {

    static void bstToDLL(Node root, Node[] head) {
        if (root == null)
            return;

        bstToDLL(root.left, head);
        if (head[0] == null) head[0] = root;
        else {
            root.left = head[0];
            head[0].right = root;
        }
        bstToDLL(root.right, head);
    }

    static Node mergeLinkedList(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.right = head1;
                head1 = head1.right;
            } else {
                temp.right = head2;
                head2 = head2.right;
            }
            temp = temp.right;
        }

        if (head1 == null) {
            temp.right = head2;
        } else {
            temp.right = head1;
        }
        return merged.right;
    }

    static Node sortedListToBST(Node[] head, int n) {
        if (n <= 0 || head[0] == null)
            return null;

        Node left = sortedListToBST(head, n / 2);
        Node root = head[0];
        root.left = left;
        head[0] = head[0].right;

        root.right = sortedListToBST(head, n - (n / 2) - 1);
        return root;
    }

    static Node mergeTrees(Node root1, Node root2, int m, int n) {
        Node[] head1 = new Node[1];
        head1[0] = null;
        bstToDLL(root1, head1);
        head1[0].left = null;

        Node[] head2 = new Node[1];
        head2[0] = null;
        bstToDLL(root2, head2);
        head2[0].left = null;

        Node head = mergeLinkedList(head1[0], head2[0]);
        return sortedListToBST(new Node[]{head}, m + n);
    }

    public static void main(String[] args) {

    }
}
