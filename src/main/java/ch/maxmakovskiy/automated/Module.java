package ch.maxmakovskiy.automated;

/**
 * Holds mappings between class information and factory responsible for creating it
 *
 * @see Factory
 */
public interface Module {
    <T> Factory<T> get(Class<T> requestedType);
}
