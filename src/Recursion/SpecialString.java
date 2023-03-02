package Recursion;

import java.util.Scanner;

// A string is called special if it consists of only stars(‘*’) and dashes(‘-’), and the number of stars is
// more than the number of dashes for any prefix of the string. 
public class SpecialString {

   /**
    * 
    * @param remainingChars - It the number of chars remaining in the ans string.
    * @param ans            - It the combination of stars and dashes which is to
    *                       print.
    * @param numberOfStars  - It is the number of stars in the string.
    * @param numberOfDashes - It is the number of dashes in the string.
    */
   public static void printSpecialString(int remainingChars, String ans, int numberOfStars, int numberOfDashes) {
      if (remainingChars == 0) {
         System.out.println(ans);
         return;
      }
      printSpecialString(remainingChars - 1, ans + "*", numberOfStars + 1, numberOfDashes);
      if (numberOfDashes + 1 <= numberOfStars)
         printSpecialString(remainingChars - 1, ans + "-", numberOfStars, numberOfDashes + 1);
   }

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      printSpecialString(n, "", 0, 0);
      sc.close();
   }
}
