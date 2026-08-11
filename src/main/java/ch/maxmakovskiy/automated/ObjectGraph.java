package ch.maxmakovskiy.automated;

import java.lang.Class;
import java.util.List;

// Also known as Injector, Component and Container
// An entry point to the DI library that holds all the modules
// with type information
public class ObjectGraph {
    private final List<Module> modules;

    public ObjectGraph(Module... modules) {
        this.modules = List.of(modules);
    }

    /**
     * Creates instance of requested type
     *
     * @param requestedType type of instance
     * */
    public <T> T get(Class<T> requestedType) {
        for (Module module : modules) {
            Factory<T> factory = module.get(requestedType);
            if (factory != null) {
                // NOTE:
                // All the factories need ObjectGraph instance
                // to create the dependencies
                return factory.get(this);
            }
        }
        throw new IllegalStateException("No factory found for "
                + requestedType.getSimpleName());
    }

}
