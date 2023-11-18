package com.github.jakubzmuda;

import com.pi4j.Pi4J;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.util.Console;
import sun.misc.Signal;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        final var console = new Console();

        var pi4j = Pi4J.newAutoContext();

        var ledConfig = DigitalOutput.newConfigBuilder(pi4j)
                .id("led")
                .name("LED Flasher")
                .address(17)
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .provider("pigpio-digital-output");
        var led = pi4j.create(ledConfig);

        Signal.handle(new Signal("INT"),
                signal -> {
                    System.out.println("Interrupted by Ctrl+C");
                    pi4j.shutdown();
                });

        while (true) {
            led.high();
            System.out.println("blink");
            Thread.sleep(50);
            led.low();
            Thread.sleep(700);
        }
    }
}
