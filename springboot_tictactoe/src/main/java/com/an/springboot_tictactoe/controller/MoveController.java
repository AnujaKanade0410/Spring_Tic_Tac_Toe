package com.an.springboot_tictactoe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.springboot_tictactoe.dto.CreateMoveDTO;
import com.an.springboot_tictactoe.dto.MoveDTO;
import com.an.springboot_tictactoe.entity.Game;
import com.an.springboot_tictactoe.entity.Move;
import com.an.springboot_tictactoe.entity.Position;
import com.an.springboot_tictactoe.service.GameService;
import com.an.springboot_tictactoe.service.MoveService;
import com.an.springboot_tictactoe.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/move")
@Slf4j
public class MoveController {

    @Autowired
    private MoveService moveService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private HttpSession httpSession;

   
    @PostMapping(value = "/create")
    public Move createMove(@RequestBody CreateMoveDTO createMoveDTO) {
        Long gameId = (Long) httpSession.getAttribute("gameId");
        log.info("move to insert:" + createMoveDTO.getBoardColumn() + createMoveDTO.getBoardRow());


        Move move = moveService.createMove(gameService.getGame(gameId), playerService.getLoggedUser(), createMoveDTO);
        Game game = gameService.getGame(gameId);
        gameService.updateGameStatus(gameService.getGame(gameId), moveService.checkCurrentGameStatus(game));

        return move;
    }

    @GetMapping(value = "/autocreate")
    public Move autoCreateMove() {
        Long gameId = (Long) httpSession.getAttribute("gameId");

        log.info("AUTO move to insert:" );

        Move move = moveService.autoCreateMove(gameService.getGame(gameId));

        Game game = gameService.getGame(gameId);
        gameService.updateGameStatus(gameService.getGame(gameId), moveService.checkCurrentGameStatus(game));

        return move;
    }


    @GetMapping(value = "/list")
    public List<MoveDTO> getMovesInGame() {

        Long gameId = (Long) httpSession.getAttribute("gameId");

      return moveService.getMovesInGame(gameService.getGame(gameId));
    }

    @GetMapping(value = "/check")
    public List<Position> validateMoves() {
        Long gameId = (Long) httpSession.getAttribute("gameId");
        return moveService.getPlayerMovePositionsInGame(gameService.getGame(gameId), playerService.getLoggedUser());
    }

    @GetMapping(value = "/turn", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isPlayerTurn() {
        Long gameId = (Long) httpSession.getAttribute("gameId");
        return moveService.isPlayerTurn(gameService.getGame(gameId), gameService.getGame(gameId).getFirstPlayer(),
                gameService.getGame(gameId).getSecondPlayer());
    }



}