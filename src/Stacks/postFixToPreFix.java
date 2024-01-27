package Stacks;

import java.util.Stack;

public class postFixToPreFix {

   public static void main(String[] args) {
      String str = "953+4*6/-";
      Stack<String> val = new Stack<>();

      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);

         if ((int) ch >= 48 && (int) ch <= 57)
            val.push(String.valueOf(ch));
         else {
            String v2 = val.pop();
            String v1 = val.pop();
            String t = ch + v1 + v2;
            val.push(t);
         }
      }
      System.out.println(val.peek());
   }
}
