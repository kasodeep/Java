package HashSets;

import java.util.HashSet;

public class Basics {

   public static void main(String[] args) {
      HashSet<String> st = new HashSet<>();
      st.add("James");
      st.add("Scott");
      st.add("John");
      st.add("James");
      System.out.println(st);
      System.out.println(st.contains("James"));
      System.out.println(st.size());
      st.remove("James");

      // Iteration over set
      for (String s : st) {
         System.out.print(s + " ");
      }
      System.out.println();
   }
}
