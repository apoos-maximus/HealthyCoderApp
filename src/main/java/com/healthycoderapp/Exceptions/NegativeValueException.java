package com.healthycoderapp.Exceptions;

public class NegativeValueException extends Exception {
    @Override
    public String toString() {
        return "Height and Weight can't be negative";
    }
}
