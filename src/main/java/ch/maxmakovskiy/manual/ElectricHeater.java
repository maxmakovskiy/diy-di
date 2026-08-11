package ch.maxmakovskiy.manual;

public class ElectricHeater implements Heater {
    private final CoffeeLogger logger;

    public ElectricHeater(CoffeeLogger logger) {
        this.logger = logger;
    }
}
