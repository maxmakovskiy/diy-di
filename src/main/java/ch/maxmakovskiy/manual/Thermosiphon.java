package ch.maxmakovskiy.manual;

public class Thermosiphon implements Pump {
    private final CoffeeLogger logger;
    private final Heater heater;

    public Thermosiphon(CoffeeLogger logger, Heater heater) {
        this.logger = logger;
        this.heater = heater;
    }
}
