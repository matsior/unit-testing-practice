package p2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        // given
        int a = 1;
        int b = 2;
        // when
        int sum = Calculator.sum(a, b);
        // then
        assertEquals(3, sum);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        // given
        int a = 3;
        int b = 2;
        // when
        int subtract = Calculator.subtract(a, b);
        // then
        assertEquals(1, subtract);
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        // given
        int a = 3;
        int b = 2;
        // when
        int multiply = Calculator.multiply(a, b);
        // then
        assertEquals(6, multiply);
    }

    @Test
    void shouldDivideTwoNumbers() {
        // given
        int a = 3;
        int b = 2;
        // when
        float divide = Calculator.divide(a, b);
        // then
        assertEquals(1.5, divide);
    }
}