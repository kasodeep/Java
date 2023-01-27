package Recursion;

public class FindUppercase {
   
   static String uppercase(String a, int idx){
      
      // Base-Case
      if(idx == a.length()) return "";

      // Self-Work
      if(Character.isUpperCase(a.charAt(idx))) return a.substring(idx);

      // Recursive-Work
      return uppercase(a, idx+1);
   }

   public static void main(String[] args) {
      
   }
}
