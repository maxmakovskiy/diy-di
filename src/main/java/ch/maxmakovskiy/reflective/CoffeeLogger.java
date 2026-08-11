package ch.maxmakovskiy.reflective;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CoffeeLogger {
    public static int counter = 0;

    @Inject
    public CoffeeLogger() {
        counter++;
        System.out.println("Creating logger " + counter + "th times");
    }
}
