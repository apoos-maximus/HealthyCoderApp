package com.healthycoderapp.Exceptions;

public class ZeroValueException extends Exception {

    @Override
    public String toString() {
        return "Height and weight can't be zero";
    }
}
