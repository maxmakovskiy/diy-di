package ch.maxmakovskiy.reflective;

import ch.maxmakovskiy.automated.FactoryHolderModule;
import ch.maxmakovskiy.automated.ObjectGraph;
import ch.maxmakovskiy.manual.Heater;
import ch.maxmakovskiy.manual.Pump;

// Docs for Inject and Singleton annotations:
// https://javax-inject.github.io/javax-inject/api/javax/inject/package-summary.html
public class ReflectiveDI {
    public static void main(String[] args) {
        var holderModule = new FactoryHolderModule();
        var reflectiveModule = new ReflectiveModule();

        holderModule.bind(Heater.class, ElectricHeater.class);
        holderModule.bind(Pump.class, Thermosiphon.class);

        var objectGraph = new ObjectGraph(holderModule, reflectiveModule);
        CoffeeMaker coffeeMaker = objectGraph.get(CoffeeMaker.class);
        coffeeMaker.brew();
    }
}
