package com.example.rpn_minesweeper.service;


import com.example.rpn_minesweeper.service.impl.RPNCalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPNCalculatorServiceTest {

    private final RPNCalculatorServiceImpl calculatorService = new RPNCalculatorServiceImpl();

    @Test
    public void testSimpleAddition() {
        String expression = "4 2 +";
        double result = calculatorService.calculateRPN(expression);
        assertEquals(6.0, result);
    }

    @Test
    public void testComplexExpression() {
        String expression = "3 5 8 * 7 + *";
        double result = calculatorService.calculateRPN(expression);
        assertEquals(141.0, result);
    }

    @Test
    public void testDivision() {
        String expression = "20 5 /";
        double result = calculatorService.calculateRPN(expression);
        assertEquals(4.0, result);
    }

    @Test
    public void testSubtraction() {
        String expression = "10 3 -";
        double result = calculatorService.calculateRPN(expression);
        assertEquals(7.0, result);
    }
}

