package Recursion;

public class MergeStrings {
   
   static String merge(String a, String b){

      String ans = "";
      // Base-Cases
      if(a.length() == 0){
         ans += b;
         return ans;
      }

      if(b.length() == 0){
         ans += a;
         return ans;
      }

      // Self-Work And Recursion
      ans += a.substring(0,1);
      ans += b.substring(0,1);
      ans += merge(a.substring(1), b.substring(1));
      return ans;
   }

   public static void main(String[] args) {
      
      String a = "abcd";
      String b = "efgh";
      System.out.println(merge(a, b));
   }
}
