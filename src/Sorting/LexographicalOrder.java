package Sorting;

public class LexographicalOrder {

   public static void sort(String[] fruits) {

      int n = fruits.length;
      for (int i = 0; i < n; i++) {
         int min_index = i;
         for (int j = i + 1; j < n; j++) {
            if (fruits[j].compareTo(fruits[min_index]) < 0) {
               min_index = j;
            }
         }
         // swap
         String temp = fruits[i];
         fruits[i] = fruits[min_index];
         fruits[min_index] = temp;
      }
   }

   public static void main(String[] args) {

      String[] fruits = { "papaya", "apple", "watermelon", "orange" };
      sort(fruits);
      for (String string : fruits) {
         System.out.print(string + " ");
      }
   }
}
