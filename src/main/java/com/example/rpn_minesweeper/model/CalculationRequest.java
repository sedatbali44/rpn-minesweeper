package com.example.rpn_minesweeper.model;

public class CalculationRequest {

    private String expression;

    // Constructor, Getters, Setters
    public CalculationRequest() {
    }

    public CalculationRequest(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}


