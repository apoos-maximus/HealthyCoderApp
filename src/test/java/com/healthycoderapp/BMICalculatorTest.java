package com.healthycoderapp;

import com.healthycoderapp.Exceptions.NegativeValueException;
import com.healthycoderapp.Exceptions.ZeroValueException;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class BMICalculatorTest {

    private String environment = "prod";

    @ParameterizedTest (name = "weight={0}, height={1}")
    @CsvFileSource(resources = "/values.csv", numLinesToSkip = 1)
    public void should_return_true(Double coderWeight, Double coderHeight) {
        //given
        double weight = coderWeight;
        double height = coderHeight;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);
    }

    @Test
    public void should_return_false() {
        //given
        double weight = 50.0;
        double height = 1.92;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(recommended);
    }

    @Test
    public void should_throwArithmaticException_when_height_zero ()
    {
        //given
        double weight = 50.0;
        double height = 0.0;

        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    public void should_return_coder_with_worst_BMI_whenCoderListNotEmpty() throws ZeroValueException, NegativeValueException {
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertAll(
                () -> assertEquals(1.82, coderWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWorstBMI.getWeight())
        );
    }

    @Test
    public void should_return_coder_with_worst_BMI_whenCoder1MsListNotEmptywithin10000ele() throws ZeroValueException, NegativeValueException {

        //given
        assumeTrue(this.environment.equals("prod"));
        List<Coder> coders = new ArrayList<>();
        for (int i=0; i < 10000; i++) {
            coders.add(new Coder(1.0 + i, 10.0 + i));
        }

        //when
        Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertTimeout(Duration.ofMillis(13), executable);
    }

    @Test
    public void should_ReturnNullWorstBMICoder_when_CoderListEmpty() {
        //given
        List<Coder> coders = new ArrayList<>();

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertNull(coderWorstBMI);
    }

    @Test
    public void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() throws ZeroValueException, NegativeValueException {

        //given
        List<Coder> coders = new ArrayList<> ();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {18.52, 29.59, 19.53};

        //when
        double [] bmiScores = BMICalculator.getBMIScores(coders);

        //then
        assertArrayEquals(expected, bmiScores);
    }
}