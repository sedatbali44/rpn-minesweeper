package com.example.rpn_minesweeper.model;


public class MinesweeperResponse {
    private String[] hints;

    public MinesweeperResponse() {
    }

    public MinesweeperResponse(String[] hints) {
        this.hints = hints;
    }

    public String[] getHints() {
        return hints;
    }

    public void setHints(String[] hints) {
        this.hints = hints;
    }
}
