package com.example.rpn_minesweeper.service;

import com.example.rpn_minesweeper.model.CalculationRequest;
import com.example.rpn_minesweeper.model.CalculationResponse;

public interface RPNCalculatorService {

    double calculateRPN(String expression);

    CalculationResponse calculate(CalculationRequest request);
}
