package com.example.rpn_minesweeper.rest;


import com.example.rpn_minesweeper.Rest.MinesweeperController;
import com.example.rpn_minesweeper.model.MinesweeperRequest;
import com.example.rpn_minesweeper.service.MinesweeperService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MinesweeperController.class)
public class MinesweeperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MinesweeperService minesweeperService;

    @Test
    public void testShowHints() throws Exception {
        String[] hints = {"**100", "33200", "1*100"};

        // Mocking the service method
        when(minesweeperService.generateHints(any(String[].class))).thenReturn(hints);

        // Mock request payload
        String requestBody = "{\"square\": [\"**...\",\".....\",\".*...\"]}";

        // Perform a POST request to /api/show-hints
        mockMvc.perform(MockMvcRequestBuilders.post("/api/show-hints")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.hints[0]").value("**100"))
                .andExpect(jsonPath("$.hints[1]").value("33200"))
                .andExpect(jsonPath("$.hints[2]").value("1*100"));
    }
}
