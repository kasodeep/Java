package Recursion;

public class AllPossibleStringsOfK {

   /**
    * 
    * @param remainingChars - It the num of characters remaining in ans.
    * @param chars          - It is the character array in which alphabets from
    *                       which string is to be made are present.
    * @param ans            - It is the ans string which is to be printesd of
    *                       length k.
    */
   public static void allStrings(int remainingChars, char[] chars, String ans) {
      if (remainingChars == 0) {
         System.out.println(ans);
         return;
      }
      for (int i = 0; i < chars.length; i++) {
         allStrings(remainingChars - 1, chars, ans + chars[i]);
      }

   }

   public static void main(String[] args) {

      char[] arr = { 'a', 'b' };
      allStrings(3, arr, "");
   }
}
