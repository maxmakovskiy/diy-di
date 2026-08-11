package ch.maxmakovskiy.manual;

public class CoffeeMaker {
    private final CoffeeLogger logger;
    private final Heater heater;
    private final Pump pump;

    public CoffeeMaker(CoffeeLogger logger, Heater heater, Pump pump) {
        this.logger = logger;
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        if (logger != null && heater != null && pump != null) {
            System.out.println("Brewing coffee...");
        } else {
            System.err.println("Oops..Something went wrong");
            System.err.println("Some dependencies are missing");
        }
    }

    public static void main(String[] args) {
        // With manual Dependency Injection,
        // creating dependencies in the right order quickly becomes a problem
        // as the number of collaborators increases
        var logger = new CoffeeLogger();
        var heater = new ElectricHeater(logger);
        var pump = new Thermosiphon(logger, heater);
        var maker = new CoffeeMaker(logger, heater, pump);
        maker.brew();
    }
}
