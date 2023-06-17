package Trees;

public class LowestCommonAncestor {

   public boolean contains(Node root, Node node) {
      if (root == null)
         return false;
      if (root == node)
         return true;
      return contains(root.left, node) || contains(root.right, node);
   }

   public Node lowestCommonAncestor(Node root, Node p, Node q) {
      if (p == null || q == null)
         return root;
      if (p == q)
         return p;
      if (p == root || q == root)
         return root;

      boolean leftp = contains(root.left, p);
      boolean rightq = contains(root.right, q);

      if ((leftp && rightq) || (!leftp && !rightq))
         return root;
      if (leftp && !rightq)
         return lowestCommonAncestor(root.left, p, q);
      if (!leftp && rightq)
         return lowestCommonAncestor(root.right, p, q);
      return null;
   }

   public static void main(String[] args) {

   }
}
