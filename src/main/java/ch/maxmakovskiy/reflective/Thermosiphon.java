package ch.maxmakovskiy.reflective;

import ch.maxmakovskiy.manual.Heater;
import ch.maxmakovskiy.manual.Pump;
import javax.inject.Inject;

public class Thermosiphon implements Pump {
    private final CoffeeLogger logger;
    private final Heater heater;

    @Inject
    public Thermosiphon(CoffeeLogger logger, Heater heater) {
        this.logger = logger;
        this.heater = heater;
    }
}
