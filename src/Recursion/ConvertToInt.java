package Recursion;

public class ConvertToInt {
   
   public static int convert(String a, int idx) {

      // Base-Case
      if (idx == 0) {
          return a.charAt(0) - '0';
      }

      // Recursion And Self-Work
      return (convert(a, idx - 1)*10 + a.charAt(idx) - '0');
  }

   public static void main(String[] args) {
      
   }
}
