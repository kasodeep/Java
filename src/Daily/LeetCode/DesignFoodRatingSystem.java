package Daily.LeetCode;

import java.util.*;

public class DesignFoodRatingSystem {

    // Food to Rating.
    private final Map<String, Integer> foodRatingMap = new HashMap<>();

    // Food to Cuisine.
    private final Map<String, String> foodCuisineMap = new HashMap<>();

    // Cuisine to TreeSet(-rating, food).
    private final Map<String, TreeSet<Pair<Integer, String>>> cuisineFoodMap = new HashMap<>();

    public DesignFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            cuisineFoodMap
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                        int compareByRating = Integer.compare(a.getKey(), b.getKey());
                        if (compareByRating == 0) return a.getValue().compareTo(b.getValue());
                        return compareByRating;
                    }))
                    // -ve to store in ascending order.
                    .add(new Pair<>(-ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisineName = foodCuisineMap.get(food);
        TreeSet<Pair<Integer, String>> cuisineSet = cuisineFoodMap.get(cuisineName);

        Pair<Integer, String> oldElement = new Pair<>(-foodRatingMap.get(food), food);
        cuisineSet.remove(oldElement);

        foodRatingMap.put(food, newRating);
        cuisineSet.add(new Pair<>(-newRating, food));
    }

    public String highestRated(String cuisine) {
        Pair<Integer, String> highestRated = cuisineFoodMap.get(cuisine).first();
        return highestRated.getValue();
    }

    public static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
