package Trees;

public class NodeAverageSum {

    static int count = 0;

    static Pair<Integer, Integer> postOrder(Node root) {
        if (root == null) return new Pair<>(0, 0);

        Pair<Integer, Integer> left = postOrder(root.left);
        Pair<Integer, Integer> right = postOrder(root.right);

        int nodeSum = left.getKey() + right.getKey() + root.val;
        int nodeCount = left.getValue() + right.getValue() + 1;

        if (root.val == nodeSum / (nodeCount)) count++;
        return new Pair<>(nodeSum, nodeCount);
    }

    public static int averageOfSubtree(Node root) {
        postOrder(root);
        return count;
    }

    public static void main(String[] args) {

    }

    public static class Pair<T, D> {
        T key;

        D value;

        public Pair(T key, D value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public D getValue() {
            return value;
        }
    }
}
