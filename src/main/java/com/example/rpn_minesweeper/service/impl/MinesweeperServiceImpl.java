package com.example.rpn_minesweeper.service.impl;


import com.example.rpn_minesweeper.service.MinesweeperService;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperServiceImpl implements MinesweeperService {

    @Override
    public String[] generateHints(String[] square) {
        int rows = square.length;
        int cols = square[0].length();
        char[][] grid = new char[rows][cols];

        // Copy input grid into a char array
        for (int i = 0; i < rows; i++) {
            grid[i] = square[i].toCharArray();
        }

        // Process each cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '.') {
                    grid[row][col] = calculateAdjacentMines(square, row, col);
                }
            }
        }

        // Convert char[][] back to String[] and return
        String[] result = new String[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = new String(grid[i]);
        }
        return result;
    }

    // Calculate the number of adjacent mines for a given cell
    private char calculateAdjacentMines(String[] square, int row, int col) {
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
        int mineCount = 0;

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];
            if (isInBounds(square, newRow, newCol) && square[newRow].charAt(newCol) == '*') {
                mineCount++;
            }
        }

        return (char) (mineCount + '0'); // Convert the number to a character
    }

    // Helper method to check if the cell is within bounds
    private boolean isInBounds(String[] square, int row, int col) {
        return row >= 0 && row < square.length && col >= 0 && col < square[0].length();
    }
}
