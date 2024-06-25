package Interview;

public class TypesOfInterfaces {

    /*
     * Normal Interface - When we have two or more methods.
     * Functional (SAM) Single Abstract Method: When we have one method.
     * Marker: It has no methods and hence empty.
     *
     * We can create properties in interface, but we cannot modify as they are final.
     * The methods are by default public.
     *
     * We can extend one class and multiple interfaces.
     * Java does not support multiple inheritance directly, but indirectly using interfaces we can implement.
     *
     * Abstract Classes:
     * We can't create objects, the methods can have body.
     * */

    interface Programmable {
        void programming();
    }

    interface Danceable {
        void dancing();
    }

    /*
     * Abstract classes when group of classes have share common attributes.
     * */
    abstract class Human {
        public abstract void name();

        public abstract void age();
    }

    class Programmer extends Human implements Programmable {

        @Override
        public void programming() {

        }

        @Override
        public void name() {

        }

        @Override
        public void age() {

        }
    }
}