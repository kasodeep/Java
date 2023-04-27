package stacks;

import java.util.Stack;

/**
 * Infix : val + operator + val
 * For Brackets : if(op.size()==0 || ch=='(') push
 * Don't forget to pop old op and push current op to the op stack.
 */
public class infixEvaluation {

   public static void main(String[] args) {

      String str = "9-(5+3)*4/6";

      // Two stacks for value and operator.
      Stack<Integer> val = new Stack<>();
      Stack<Character> op = new Stack<>();

      // Iterate over the loop
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         int ascii = (int) ch;

         // If it is an value push it to the val stack. ascii -> 0->48 & 9->57
         if (ascii >= 48 && ascii <= 57)
            val.push(ascii - 48);

         // If op stack is empty push the operator.
         else if (op.size() == 0 || ch == '(' || op.peek() == '(')
            op.push(ch);

         else if (ch == ')') {
            while (op.peek() != '(') {
               int v2 = val.pop();
               int v1 = val.pop();
               if (op.peek() == '-')
                  val.push(v1 - v2);
               if (op.peek() == '+')
                  val.push(v1 + v2);
               if (op.peek() == '*')
                  val.push(v1 * v2);
               if (op.peek() == '/')
                  val.push(v1 / v2);

               op.pop();
            }
            op.pop(); // '(' removed
         }

         else {
            // if '+' or '-' do the work as there is least precedence of this two.
            if (ch == '+' || ch == '-') {
               int v2 = val.pop();
               int v1 = val.pop();
               if (op.peek() == '-')
                  val.push(v1 - v2);
               if (op.peek() == '+')
                  val.push(v1 + v2);
               if (op.peek() == '*')
                  val.push(v1 * v2);
               if (op.peek() == '/')
                  val.push(v1 / v2);

               op.pop();
               op.push(ch);
            }

            if (ch == '*' || ch == '/') {
               if (op.peek() == '*' || op.peek() == '/') {
                  int v2 = val.pop();
                  int v1 = val.pop();
                  if (op.peek() == '-')
                     val.push(v1 - v2);
                  if (op.peek() == '+')
                     val.push(v1 + v2);
                  if (op.peek() == '*')
                     val.push(v1 * v2);
                  if (op.peek() == '/')
                     val.push(v1 / v2);

                  op.pop();
                  op.push(ch);
               } else {
                  op.push(ch);
               }
            }

         }
      }

      // Emptying the stack and calculating
      while (val.size() > 1) {
         int v2 = val.pop();
         int v1 = val.pop();
         if (op.peek() == '-')
            val.push(v1 - v2);
         if (op.peek() == '+')
            val.push(v1 + v2);
         if (op.peek() == '*')
            val.push(v1 * v2);
         if (op.peek() == '/')
            val.push(v1 / v2);

         op.pop();
      }

      System.out.println(val.peek());
   }
}
