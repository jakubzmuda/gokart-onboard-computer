package com.github.jakubzmuda.powerunit;

public class PowerRequest {

    private final int powerPercentage;

    public PowerRequest(int powerPercentage) {
        if(powerPercentage < 0 || powerPercentage > 100) {
            throw new RuntimeException("Power request of " + powerPercentage + " is out of bounds <0, 100>");
        }
        this.powerPercentage = powerPercentage;
    }

    public int getPowerPercentage() {
        return powerPercentage;
    }
}
