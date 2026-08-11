package ch.maxmakovskiy;

import ch.maxmakovskiy.automated.*;
import ch.maxmakovskiy.manual.*;

public class DI {
    public static void main(String[] args) {
        var module = new FactoryHolderModule();

        module.bind(Heater.class, ElectricHeater.class);
        module.bind(Pump.class, Thermosiphon.class);

        module.installSingleton(CoffeeLogger.class, new CoffeeLoggerFactory());
        module.installSingleton(ElectricHeater.class, new ElectricHeaterFactory());
        module.install(Thermosiphon.class, new ThermosiphonFactory());
        module.install(CoffeeMaker.class, new CoffeeMakerFactory());

        var objectGraph = new ObjectGraph(module);
        CoffeeMaker coffeeMaker = objectGraph.get(CoffeeMaker.class);
        coffeeMaker.brew();
    }
}
