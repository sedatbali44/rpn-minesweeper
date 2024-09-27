package com.example.rpn_minesweeper.Rest;


import com.example.rpn_minesweeper.model.MinesweeperRequest;
import com.example.rpn_minesweeper.model.MinesweeperResponse;
import com.example.rpn_minesweeper.service.MinesweeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MinesweeperController {

    @Autowired
    private MinesweeperService minesweeperService;

    @PostMapping("/show-hints")
    public MinesweeperResponse showHints(@RequestBody MinesweeperRequest request) {
        String[] hints = minesweeperService.generateHints(request.getSquare());
        return new MinesweeperResponse(hints);
    }
}
