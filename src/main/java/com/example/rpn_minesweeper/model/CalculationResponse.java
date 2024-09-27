package com.example.rpn_minesweeper.model;

public class CalculationResponse {

    private double result;

    // Constructor, Getters, Setters
    public CalculationResponse() {
    }

    public CalculationResponse(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
