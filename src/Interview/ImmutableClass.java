package Interview;

/*
 * Once, we create the object it's value should not change.
 * */
public record ImmutableClass(int id, String name, Engine engine) {

    public ImmutableClass(int id, String name, Engine engine) {
        this.id = id;
        this.name = name;

        Engine newEngine = new Engine(engine.speed);
        this.engine = newEngine;
    }
}

class Engine {

    int speed;

    public Engine(int speed) {
        this.speed = speed;
    }
}
