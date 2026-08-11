package ch.maxmakovskiy.automated;

import ch.maxmakovskiy.manual.Thermosiphon;
import ch.maxmakovskiy.manual.CoffeeLogger;
import ch.maxmakovskiy.manual.ElectricHeater;
import ch.maxmakovskiy.manual.Heater;

public class ThermosiphonFactory implements Factory<Thermosiphon> {
    @Override
    public Thermosiphon get(ObjectGraph objectGraph) {
        CoffeeLogger logger = objectGraph.get(CoffeeLogger.class);
        Heater heater = objectGraph.get(ElectricHeater.class);
        return new Thermosiphon(logger, heater);
    }
}
