package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 20));
        personList.add(new Person("Bob", 25));
        personList.add(new Person("Charlie", 30));

        Consumer<Person> increaseAge = person -> person.setAge(person.getAge() + 1);
        Consumer<Person> printPerson = person -> System.out.println("Person: " + person.toString());

        Consumer<Person> incrementAndPrint = increaseAge.andThen(printPerson);
        personList.forEach(incrementAndPrint);
    }
}
