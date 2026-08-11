package ch.maxmakovskiy.automated;

import ch.maxmakovskiy.manual.CoffeeLogger;
import ch.maxmakovskiy.manual.CoffeeMaker;
import ch.maxmakovskiy.manual.Heater;
import ch.maxmakovskiy.manual.Pump;

public class CoffeeMakerFactory implements Factory<CoffeeMaker> {
    @Override
    public CoffeeMaker get(ObjectGraph objectGraph) {
        CoffeeLogger logger = objectGraph.get(CoffeeLogger.class);
        Heater heater = objectGraph.get(Heater.class);
        Pump pump = objectGraph.get(Pump.class);
        return new CoffeeMaker(logger, heater, pump);
    }
}
