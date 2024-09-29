package com.example.rpn_minesweeper.Rest;

import com.example.rpn_minesweeper.model.CalculationRequest;
import com.example.rpn_minesweeper.model.CalculationResponse;
import com.example.rpn_minesweeper.service.RPNCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private RPNCalculatorService rpnCalculatorService;

    @PostMapping("/calculate")
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        return rpnCalculatorService.calculate(request);
    }
}