package com.healthycoderapp;

import com.healthycoderapp.Exceptions.NegativeValueException;
import com.healthycoderapp.Exceptions.ZeroValueException;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CoderTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/NegavtiveValueCoder.csv", numLinesToSkip = 1)
    public void NegativeValueTest (double coderHeight, double coderWeight) {
        double height = coderHeight;
        double weight = coderWeight;
        Executable executable = () -> new Coder (height, weight);
        assertThrows(NegativeValueException.class, executable);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ZeroValueCoders.csv", numLinesToSkip = 1)
    public void ZeroValueTest (double coderHeight, double coderWeight) {
        double height = coderHeight;
        double weight = coderWeight;
        Executable executable = () -> new Coder (height, weight);
        assertThrows(ZeroValueException.class, executable);
    }

}