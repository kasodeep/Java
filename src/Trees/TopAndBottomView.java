package Trees;

import java.util.HashMap;
import java.util.Map;

public class TopAndBottomView {

    private static int right(Node root) {
        if (root == null) return 0;
        return 1 + right(root.right);
    }

    private static int left(Node root) {
        if (root == null) return 0;
        return 1 + left(root.left);
    }

    private static void bottomView(Node root, int level, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(level, root.val);

        // Right is on top because, we want to go post order so that over lapping it selects left.
        bottomView(root.right, level - 1, map);
        bottomView(root.left, level + 1, map);
    }

    private static void printVertical(Node root, int givenLevel, int currentLevel) {
        if (root == null) return;
        if (currentLevel == givenLevel) {
            System.out.print(root.val + " ");
            return;   // Very Important, if we return from here we print the top view else we print vertical level.
        }
        printVertical(root.left, givenLevel, currentLevel - 1);
        printVertical(root.right, givenLevel, currentLevel + 1);
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6", "7"};
        Node root = ConstructTree.construct(arr);
        int leftCount = left(root);
        int rightCount = right(root);

//        For Printing Top View.
        for (int i = 1 - leftCount; i < rightCount; i++) {
            printVertical(root, i, 0);
        }

        System.out.println();

//        For Printing Bottom View.
        Map<Integer, Integer> map = new HashMap<>();
        bottomView(root, 0, map);

        for (int i = 1 - leftCount; i < rightCount; i++) {
            System.out.print(map.get(i) + " ");
        }
    }
}
