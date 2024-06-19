package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightAndLeftView {

    List<Integer> result = new ArrayList<>();
    int maxLevel = 0;

    public List<Integer> rightSideView(Node root) {
        if (root == null) return result;
        helper(root, 0);
        return result;
    }

    public void helper(Node root, int level) {
        if (root == null) return;
        if (level >= maxLevel) {
            result.add(root.val);
            maxLevel++;
        }

        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }
}
