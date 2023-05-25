package HashSets;

import java.util.HashSet;

/*
 * A bag contains pair numbers and you have to pick one at a ,
 * time and add that to table if it's pair is in the bag.
 */
public class MaxNumbers {

   /*
    * @param bag The array of numbers to add to the table.
    */
   static int maxNumbersOnTable(int[] bag) {
      HashSet<Integer> table = new HashSet<>();
      int max = 0;

      for (int i = 0; i < bag.length; i++) {
         int num = bag[i];
         if (table.contains(num)) {
            table.remove(num);
         } else {
            table.add(num);
            max = Math.max(max, table.size());
         }
      }
      return max;
   }

   public static void main(String[] args) {
      int[] nums = { 2, 1, 1, 3, 2, 3 };
      System.out.println(maxNumbersOnTable(nums));
   }
}
