package ch.maxmakovskiy.reflective;

import ch.maxmakovskiy.automated.Factory;
import ch.maxmakovskiy.automated.ObjectGraph;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import javax.inject.Inject;

/** Allows to generate correct factory at runtime by using reflection API */
public class ReflectiveFactory<T> implements Factory<T> {
    private final Constructor<T> injectedConstructor;

    public ReflectiveFactory(Class<T> requestedType) {
        injectedConstructor =
                (Constructor<T>)
                        Arrays.stream(requestedType.getDeclaredConstructors())
                                .filter(c -> c.isAnnotationPresent(Inject.class))
                                .findFirst()
                                .get();
    }

    @Override
    public T get(ObjectGraph objectGraph) {
        Class<?>[] paramTypes = injectedConstructor.getParameterTypes();
        var params = Arrays.stream(paramTypes).map(objectGraph::get).toArray();
        try {
            return injectedConstructor.newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(
                    "Oops... Cannot instantiate class "
                            + injectedConstructor.getName()
                            + "; Because of "
                            + e.getMessage());
            return null;
        }
    }
}
