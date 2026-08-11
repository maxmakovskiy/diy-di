package ch.maxmakovskiy.manual;

public class CoffeeLogger {
    private static int counter = 0;

    public CoffeeLogger() {
        counter++;
        System.out.println("Creating logger " + counter + "th time");
    }
}
