package NAryTree;

import java.util.Collections;

public class MirrorTree {

    static void mirrorTree(Node root) {
        if (root == null)
            return;

        int n = root.children.size();
        if (n < 2) return;

        for (int i = 0; i < n; i++)
            mirrorTree(root.children.get(i));
        Collections.reverse(root.children);
    }

    public static void main(String[] args) {

    }
}
