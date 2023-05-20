package HashMaps;

import java.util.HashMap;

public class Anagram {

   /*
    * Utility function to print calculate the frequency map.
    */
   static HashMap<Character, Integer> makeFreqMap(String str) {
      HashMap<Character, Integer> mp = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
         Character ch = str.charAt(i);

         if (!mp.containsKey(ch)) {
            mp.put(ch, 1);
         } else {
            mp.put(ch, mp.get(ch) + 1);
         }
      }
      return mp;
   }

   /*
    * Same letter rearranged in both the strings is an Anagram.
    */
   public static boolean isAnagram(String s, String t) {
      if (s.length() != t.length())
         return false;
      HashMap<Character, Integer> mp = makeFreqMap(s);

      for (int i = 0; i < t.length(); i++) {
         Character ch = t.charAt(i);
         if (!mp.containsKey(ch))
            return false;

         mp.put(ch, mp.get(ch) - 1);
      }

      for (Integer i : mp.values()) {
         if (i != 0)
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isAnagram("knee", "keen"));
   }
}
