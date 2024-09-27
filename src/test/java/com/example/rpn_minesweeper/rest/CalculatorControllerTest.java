package com.example.rpn_minesweeper.rest;


import com.example.rpn_minesweeper.Rest.CalculatorController;
import com.example.rpn_minesweeper.service.RPNCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CalculatorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RPNCalculatorService rpnCalculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    void calculate_shouldReturnResult() throws Exception {
        String expression = "20 5 /";
        when(rpnCalculatorService.calculateRPN(expression)).thenReturn(4.0);

        mockMvc.perform(post("/api/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"expression\": \"20 5 /\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\": 4.0}"));
    }
}

