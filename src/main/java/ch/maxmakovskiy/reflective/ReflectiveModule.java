package ch.maxmakovskiy.reflective;

import ch.maxmakovskiy.automated.Factory;
import ch.maxmakovskiy.automated.Module;
import ch.maxmakovskiy.automated.SingletonFactory;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

/** Stores generated (during runtime) factories */
public class ReflectiveModule implements Module {
    private final Map<Class<?>, Factory<?>> factories = new HashMap<>();

    @Override
    public <T> Factory<T> get(Class<T> requestedType) {
        Factory<?> existing = factories.get(requestedType);

        if (existing != null) {
            return (Factory<T>) existing;
        }

        Factory<T> factory;
        if (requestedType.isAnnotationPresent(Singleton.class)) {
            // for classes annotated as Singleton
            // wrap corresponding factories with SingletonFactory
            factory = new SingletonFactory<>(new ReflectiveFactory<>(requestedType));
        } else {
            factory = new ReflectiveFactory<>(requestedType);
        }

        factories.put(requestedType, factory);
        return factory;
    }
}
