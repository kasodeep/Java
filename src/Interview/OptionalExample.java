package Interview;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Person person = new Person(Optional.empty());

        String city = person
                .address()
                .map(Address::getCity)
                .orElse("Unknown");

        // Print city if present.
        person.address().ifPresent(address -> System.out.println("City: " + address.getCity()));

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

    record Person(Optional<Address> address) {
    }
}
