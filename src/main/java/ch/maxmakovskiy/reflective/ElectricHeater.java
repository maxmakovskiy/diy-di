package ch.maxmakovskiy.reflective;

import ch.maxmakovskiy.manual.Heater;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ElectricHeater implements Heater {
    private final CoffeeLogger logger;

    @Inject
    public ElectricHeater(CoffeeLogger logger) {
        this.logger = logger;
    }
}
