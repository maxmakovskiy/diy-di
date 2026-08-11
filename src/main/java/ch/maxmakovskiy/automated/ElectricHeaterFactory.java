package ch.maxmakovskiy.automated;

import ch.maxmakovskiy.manual.CoffeeLogger;
import ch.maxmakovskiy.manual.ElectricHeater;

public class ElectricHeaterFactory implements Factory<ElectricHeater> {
    @Override
    public ElectricHeater get(ObjectGraph objectGraph) {
        CoffeeLogger logger = objectGraph.get(CoffeeLogger.class);
        return new ElectricHeater(logger);
    }
}
