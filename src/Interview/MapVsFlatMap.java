package Interview;

import java.util.Arrays;
import java.util.List;

public class MapVsFlatMap {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python");
        List<String> upperCaseLanguages = languages
                .stream()
                .map(String::toUpperCase)
                .toList();

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Java", "SpringBoot"),
                Arrays.asList("Python", "Django")
                );

        List<String> flattenList = nestedList
                .stream()
                .flatMap(List::stream)
                .map(String::toUpperCase)
                .toList();
    }
}
