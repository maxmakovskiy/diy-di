package ch.maxmakovskiy.automated;

public class SingletonFactory<T> implements Factory<T> {

    private final Factory<T> delegate;
    private boolean initialized;
    private T instance;

    public SingletonFactory(Factory<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T get(ObjectGraph objectGraph) {
        if (!initialized) {
            instance = delegate.get(objectGraph);
            initialized = true;
        }
        return instance;
    }
}
