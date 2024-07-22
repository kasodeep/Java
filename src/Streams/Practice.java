package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(20, 100, "Tech"));
        employees.add(new Employee(40, 300, "Market"));
        employees.add(new Employee(35, 200, "Tech"));

        // Highest Salary
        Optional<Employee> highestSalary = employees
                .stream()
                .max(Comparator.comparing(Employee::getSalary));

        List<String> words = new ArrayList<>(Arrays.asList("Deep", "Parth", "Neeta"));

        // Concatenate Strings
        String collected = words
                .stream()
                .collect(Collectors.joining(", "));
        System.out.println(collected);

        String repeatingCharacter = "Kasodariya Deep";

        // First Repeating Character
        Optional<Character> firstRepeating = repeatingCharacter
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        // Collect Employees of Specific Department
        Set<Employee> techEmployees = employees
                .stream()
                .filter(employee -> employee.getDepartment().equals("Tech"))
                .collect(Collectors.toSet());

        // Age of Oldest Person
        Optional<Integer> ageOfOldestEmployee = employees
                .stream()
                .max(Comparator.comparing(Employee::getAge))
                .map(Employee::getAge);

        // Filter Out Null Values
        List<Employee> nullEmployees = employees
                .stream()
                .filter(Objects::nonNull)
                .toList();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20));

        // Sum Of Squares
        int sumOfSquares = numbers
                .stream()
                .mapToInt(i -> i * i)
                .sum();

        // Skip Operation
        employees
                .stream()
                .skip(2)
                .forEach(System.out::println);

        // Infinite Series / Limit
        new Random()
                .ints()
                .limit(10)
                .forEach(System.out::println);

        // Starts With
        boolean isPrefix = words
                .stream()
                .anyMatch(s -> s.startsWith("De"));
    }
}
