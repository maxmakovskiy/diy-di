package ch.maxmakovskiy.automated;

/**
 * Produces instances by using ObjectGraph
 * @see ObjectGraph
 * */
public interface Factory<T> {
    T get(ObjectGraph objectGraph);
}
