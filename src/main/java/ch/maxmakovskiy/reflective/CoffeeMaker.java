package ch.maxmakovskiy.reflective;

import ch.maxmakovskiy.manual.Heater;
import ch.maxmakovskiy.manual.Pump;
import javax.inject.Inject;

public class CoffeeMaker {
    private final CoffeeLogger logger;
    private final Heater heater;
    private final Pump pump;

    @Inject
    public CoffeeMaker(CoffeeLogger logger, Heater heater, Pump pump) {
        this.logger = logger;
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        if (logger != null && heater != null && pump != null) {
            System.out.println("Brewing coffee...");
        } else {
            System.out.println("Oops..Something went wrong");
        }
    }
}
