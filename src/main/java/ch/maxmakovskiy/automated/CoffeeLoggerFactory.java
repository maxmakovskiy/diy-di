package ch.maxmakovskiy.automated;

import ch.maxmakovskiy.manual.CoffeeLogger;

public class CoffeeLoggerFactory implements Factory<CoffeeLogger> {
    @Override
    public CoffeeLogger get(ObjectGraph objectGraph) {
        return new CoffeeLogger();
    }
}
