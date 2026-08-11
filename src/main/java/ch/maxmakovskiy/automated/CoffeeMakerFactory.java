package ch.maxmakovskiy.automated;

import ch.maxmakovskiy.manual.*;

public class CoffeeMakerFactory implements Factory<CoffeeMaker> {
    @Override
    public CoffeeMaker get(ObjectGraph objectGraph) {
        CoffeeLogger logger = objectGraph.get(CoffeeLogger.class);
        Heater heater = objectGraph.get(Heater.class);
        Pump pump = objectGraph.get(Pump.class);
        return new CoffeeMaker(logger, heater, pump);
    }
}
