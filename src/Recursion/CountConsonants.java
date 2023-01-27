package Recursion;

public class CountConsonants {
   
   public static boolean isconsonant(char ch){
      ch = Character.toLowerCase(ch);
      if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
          return false;
      }
      return true;
  }

   static int count(String a, int idx){

      // Base-Case
      if (idx == 1) {
         if(isconsonant(a.charAt(0)))
             return 1;
         else
             return 0;
     }
     
    //  Recursion And Self-Work
     if(isconsonant(a.charAt(idx - 1)))
         return count(a, idx - 1) + 1;
     else
         return count(a, idx - 1);
   }

   public static void main(String[] args) {
      
   }
}
