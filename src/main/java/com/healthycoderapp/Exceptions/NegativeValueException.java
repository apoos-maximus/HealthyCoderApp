package com.healthycoderapp.Exceptions;

public class NegativeValueException extends Exception {
    String property;

    public NegativeValueException (String property) {
        this.property = property;
    }
    @Override
    public String toString() {
        return this.property + "can't be negative";
    }
}
