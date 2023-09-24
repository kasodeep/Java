package NAryTree;

public class NextGreater {

    static Node res = null;

    public static void nextLargerElement(Node node, int x) {
        if (node == null)
            return;

        if (node.data > x)
            if (res == null || res.data > node.data)
                res = node;

        for (int i = 0; i < node.children.size(); i++)
            nextLargerElement(node.children.get(i), x);
    }

    public static void main(String[] args) {

    }
}
