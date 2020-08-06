package com.healthycoderapp.Exceptions;

public class ZeroValueException extends Exception {
    String property;

    public ZeroValueException (String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return this.property + "can't be zero";
    }
}
