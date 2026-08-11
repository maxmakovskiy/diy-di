package ch.maxmakovskiy.automated;

/* Allows to resolve interfaces to concrete implementations
 * such as Heater to ElectricHeater
 * Basically it special type of factory producing concrete classes instead of instances
 * and then through `get` method and `ObjectGraph` usage it eventually looks up
 * factories producing instances of ElectricHeater - ElectricHeaterFactory for example.
 * Binding Factory gives the way to avoid declaring concrete classes in CoffeeMaker
 * allowing just to declare interfaces (contracts) and inject the implementations latter
 * */
public class BindingFactory<RequestedType, ProvidedType extends RequestedType>
        implements Factory<RequestedType> {

    private final Class<ProvidedType> providedType;

    public BindingFactory(Class<ProvidedType> providedType) {
        this.providedType = providedType;
    }

    @Override
    public RequestedType get(ObjectGraph objectGraph) {
        return objectGraph.get(providedType);
    }
}
