package ch.maxmakovskiy.automated;

import java.util.HashMap;

public class FactoryHolderModule implements Module {
    // NOTE:
    // we can use unbounded wildcard since
    // we use methods that rather depend on Class and Factory classes
    // than type represented by ?
    // hence the wildcard (the sign that we do not care about type)
    private final HashMap<Class<?>, Factory<?>> factories;

    public FactoryHolderModule() {
        this.factories = new HashMap<>();
    }

    /** Returns factory responsible for creating instance of requested type */
    @Override
    public <T> Factory<T> get(Class<T> requestedType) {
        // NOTE:
        // We do unchecked cast as we do not know exact generic type in `factories`
        // Hence wildcard is there
        return (Factory<T>) factories.get(requestedType);
    }

    /** Adds mapping type-factory to the module */
    public <T> void install(Class<T> requestedType, Factory<T> factory) {
        factories.put(requestedType, factory);
    }

    /**
     * Adds mapping type-factory to the module additionally ensuring that the factory produces
     * desired instance no more than once
     *
     * @see SingletonFactory
     */
    public <T> void installSingleton(Class<T> requestedType, Factory<T> factory) {
        install(requestedType, new SingletonFactory<>(factory));
    }

    /**
     * Adds meta mapping interface-class to facilitate eventual resolution of interface to the
     * concrete implementation (class) and allowing later to identify factory producing it
     *
     * @see BindingFactory
     */
    public <RequestedType, ProvidedType extends RequestedType> void bind(
            Class<RequestedType> requestedType, Class<ProvidedType> providedType) {

        install(requestedType, new BindingFactory<>(providedType));
    }
}
