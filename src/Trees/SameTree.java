package Trees;

public class SameTree {

   public static boolean isSameTree(Node p, Node q) {
      if (p == null && q == null)
         return true;

      if (p == null || q == null)
         return false;
      if (p.val != q.val)
         return false;

      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   }

   public static void main(String[] args) {

   }
}
