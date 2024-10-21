package Interview.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorePractice {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(10, 35, 40));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20));

        // Merge Two Lists
        List<Integer> mergedList = Stream
                .concat(list1.stream(), list2.stream())
                .distinct()
                .toList();

        // Average Of Numbers Greater Than 10
        OptionalDouble average = list1
                .stream()
                .filter(n -> n > 10)
                .mapToInt(Integer::intValue)
                .average();

        // Even Odd Partitioning
        Map<Boolean, List<Integer>> EvenOddList = list1
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        List<String> sentences = new ArrayList<>(List.of("This is Deep"));

        // Collect Unique Words.
        Set<String> uniqueWords = sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .collect(Collectors.toSet());

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);

        // List of List of Integers
        List<Integer> flattenedList = list
                .stream()
                .flatMap(List::stream)
                .toList();

        List<String> words = new ArrayList<>(Arrays.asList("Deep", "Parth", "Neeta"));

        // Map of Strings - Length
        Map<Integer, List<String>> byLength = words
                .stream()
                .collect(Collectors.groupingBy(String::length));

        Map<String, Integer> stringLengthMap = words
                .stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        // Product of All Numbers
        Integer productOfNumbers = list1
                .stream()
                .reduce(1, (a, b) -> a * b);
    }
}
