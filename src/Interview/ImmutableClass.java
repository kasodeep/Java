package Interview;

/*
 * Once, we create the object it's value should not change.
 * */
public final class ImmutableClass {

    private final int id;
    private final String name;
    private final Engine engine;

    public ImmutableClass(int id, String name, Engine engine) {
        this.id = id;
        this.name = name;

        Engine newEngine = new Engine(engine.speed);
        this.engine = newEngine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }
}

class Engine {

    int speed;

    public Engine(int speed) {
        this.speed = speed;
    }
}
