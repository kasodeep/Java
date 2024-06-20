package Interview;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Person person = new Person(Optional.empty());

        String city = person
                .getAddress()
                .map(Address::getCity)
                .orElse("Unknown");

        // Print city if present.
        person.getAddress().ifPresent(address -> System.out.println("City: " + address.getCity()));

    }

    static class Address {
        private String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    static class Person {
        private Optional<Address> address;

        public Person(Optional<Address> address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return address;
        }
    }
}
