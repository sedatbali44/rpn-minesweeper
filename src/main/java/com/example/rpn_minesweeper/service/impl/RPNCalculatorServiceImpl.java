package com.example.rpn_minesweeper.service.impl;

import com.example.rpn_minesweeper.model.CalculationRequest;
import com.example.rpn_minesweeper.model.CalculationResponse;
import com.example.rpn_minesweeper.service.RPNCalculatorService;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class RPNCalculatorServiceImpl implements RPNCalculatorService {

    @Override
    public double calculateRPN(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    double subtrahend = stack.pop();
                    stack.push(stack.pop() - subtrahend);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }

        return stack.pop();
    }

    @Override
    public CalculationResponse calculate(CalculationRequest request) {
        double result = calculateRPN(request.getExpression());
        return new CalculationResponse(result);
    }
}
