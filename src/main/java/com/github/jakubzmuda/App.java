package com.github.jakubzmuda;

import com.github.jakubzmuda.powerunit.PowerUnit;
import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.util.Console;
import sun.misc.Signal;

public class App {
    public static void main(String[] args) throws InterruptedException {

        final var console = new Console();
        var pi4j = Pi4J.newAutoContext();

        PowerUnit powerUnit = new PowerUnit(pi4j);

//        powerUnit.requestPower();

        handleInterruptSignal(pi4j);
        keepTheAppRunning();
    }

    private static void handleInterruptSignal(Context pi4j) {
        Signal.handle(new Signal("INT"),
                signal -> {
                    System.out.println("Interrupted by Ctrl+C");
                    pi4j.shutdown();
                });
    }

    private static void keepTheAppRunning() {
        while (true) {
        }
    }
}
