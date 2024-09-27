package com.example.rpn_minesweeper.model;


public class MinesweeperRequest {
    private String[] square;

    public MinesweeperRequest() {
    }

    public MinesweeperRequest(String[] square) {
        this.square = square;
    }

    public String[] getSquare() {
        return square;
    }

    public void setSquare(String[] square) {
        this.square = square;
    }
}
