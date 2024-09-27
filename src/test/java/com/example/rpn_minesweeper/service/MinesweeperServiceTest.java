package com.example.rpn_minesweeper.service;

import com.example.rpn_minesweeper.service.impl.MinesweeperServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinesweeperServiceTest {

    private final MinesweeperServiceImpl minesweeperService = new MinesweeperServiceImpl();

    @Test
    public void testGenerateHints() {
        String[] input = {
                "*...",
                "....",
                ".*..",
                "...."
        };
        String[] expected = {
                "*100",
                "2210",
                "1*10",
                "1110"
        };

        String[] result = minesweeperService.generateHints(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testComplexGrid() {
        String[] input = {
                "**...",
                ".....",
                ".*..."
        };
        String[] expected = {
                "**100",
                "33200",
                "1*100"
        };

        String[] result = minesweeperService.generateHints(input);
        assertArrayEquals(expected, result);
    }
}
