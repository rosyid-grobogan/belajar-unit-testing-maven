package com.belajar;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.bind.ValidationException;

public class CalculatorTest {

    private Calculator calculator;
    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAddPositiveNumbers() {
        // arrange
        int a = 2;
        int b = 3;

        // act
        int result = calculator.add(a, b);

        // assert
        assertEquals(5 , result);
    }

    @Test
    public void testAddZeroToPositive() {
        // arrange
        int a = 5;
        int b = 0;

        // act
        int result = calculator.add(a, b);

        // assert
        assertEquals(5 , result);
    }

    // error
//    @Test
//    public void testAdd() {
//        throw new RuntimeException("Oops!");
//    }
//
//    // success
//    @Test(expected = RuntimeException.class)
//    public void testAdd2() {
//        throw new RuntimeException("Oops!");
//    }
//
//    @Test
//    public void failAdd(){
//        Assert.fail("Failing the test!");
//    }

//    @Test
//    public void failTryCatchAdd(){
//        try {
//            // give bad input to SUT
//            Assert.fail("Failing the test!");
//        } catch (ValidationException e) {
//
//        }
//
//    }

//    @Test
//    public void testAssertforAdd(){
//        Assert.fail("Failing the test!");
//    }

//    @Test
//    public void testforAdd(){
//        // arrange
//
//        // act
//
//        // assert
//        assertNotNull(new Object());
//        assertTrue("must be 10", 10 == 10);
//        assertNotEquals(1L, 2L);
//    }

//    @Test
//    public void testforAdd() {
//        // arrange
//        int a = 2;
//        int b = 3;
//
//        // act
//        int result = Calculator.add(a, b);
//
//        // assert
//        assertEquals(5, result);
//    }


}