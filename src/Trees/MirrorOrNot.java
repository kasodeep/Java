package Trees;

public class MirrorOrNot {

    static boolean areMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }
}
