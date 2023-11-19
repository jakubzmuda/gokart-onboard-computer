package com.github.jakubzmuda.powerunit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PowerRequestTest {

    @Test
    public void shouldInstantiateAValidPowerRequest() {
        assertThat(new PowerRequest(20).getPowerPercentage()).isEqualTo(20);
    }

    @Test
    public void shouldThrowWhenPowerPercentageLessThanZero() {
        assertThatThrownBy(() -> new PowerRequest(-1)).hasMessage("Power request of -1 is out of bounds <0, 100>");
    }

    @Test
    public void shouldThrowWhenPowerPercentageOver100() {
        assertThatThrownBy(() -> new PowerRequest(101)).hasMessage("Power request of 101 is out of bounds <0, 100>");
    }

}
