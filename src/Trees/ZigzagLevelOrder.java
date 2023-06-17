package Trees;

/* It means to travel in level order, but in an alternate fashion. */
public class ZigzagLevelOrder {

    public static int height(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static void nthLevel(Node root, int n) {
        if(root == null) return;

        if(n==1){
            System.out.print(root.val + " ");
            return;
        }
        nthLevel(root.left, n-1);
        nthLevel(root.right, n-1);
    }

    private static void nthLevel2(Node root, int n) {
        if(root == null) return;

        if(n==1){
            System.out.print(root.val + " ");
            return;
        }
        nthLevel2(root.right, n-1);
        nthLevel2(root.left, n-1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        int level = height(root) + 1;
        for (int i = 1; i <= level; i++) {
            if(i % 2 != 0) nthLevel(root, i);
            else nthLevel2(root, i);
            System.out.println();
        }
    }
}
