package HashMaps;

import java.util.HashMap;
import java.util.Map;

/*
 * Searching, Insertion, Deletion, Contains -> O(1);
 * HashMaps are unordered in Java.
 * HashMap doesn't allow duplicate keys but allows duplicate values.
 * HashMap allows null key but only once.
 */
public class Basics {

   public static void HashMapEx() {
      // Syntax
      Map<String, Integer> map = new HashMap<>();

      // Adding Elements
      map.put("John Cena", 60);
      map.put("Randy Orton", 42);
      map.put("Roman Reigns", 25);

      // Getting value of a Key
      System.out.println(map.get("Roman Reigns")); // 25
      System.out.println(map.get("Triple H")); // null

      // Changing value of a Key
      map.put("John Cena", 56);

      // Removing a pair
      System.out.println(map.remove("Randy Orton"));
      System.out.println(map.remove("Big Show"));

      // Checking if the Key is in a HashMap
      System.out.println(map.containsKey("John Cena"));
      System.out.println(map.containsKey("Brock Lesnar"));

      // Adding a new pair only if the map doesn't contain the Key
      map.putIfAbsent("Seth Rollins", 40);
      map.putIfAbsent("Roman Reigns", 34);

      // Get all Keys in the HashMap
      System.out.println(map.keySet());

      // Get all Values in the HashMap
      System.out.println(map.values());

      // Get all Entries in the HashMap
      System.out.println(map.entrySet());

      // Iteration
      for (String key : map.keySet()) {
         System.out.printf("Age of %s is %d\n", key, map.get(key));
      }

      for (Map.Entry<String, Integer> e : map.entrySet()) {
         System.out.printf("Age of %s is %d\n", e.getKey(), e.getValue());
      }

      // Using var
      for (var e : map.entrySet()) {
         System.out.printf("Age of %s is %d\n", e.getKey(), e.getValue());
      }
   }

   public static void main(String[] args) {
      HashMapEx();
   }
}
