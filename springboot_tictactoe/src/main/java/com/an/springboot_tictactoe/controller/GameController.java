package com.an.springboot_tictactoe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.springboot_tictactoe.dto.GameDTO;
import com.an.springboot_tictactoe.entity.Game;
import com.an.springboot_tictactoe.service.GameService;
import com.an.springboot_tictactoe.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/game")
@Slf4j
public class GameController {
	 @Autowired
	 GameService gameService;

	 @Autowired
	 PlayerService playerService;

	 @Autowired
	 HttpSession httpSession;
	 
	 @PostMapping("/create")
	 public Game createNewGame(@RequestBody GameDTO gameDTO) {

		 Game game = gameService.createNewGame(playerService.getLoggedUser(), gameDTO);
		 httpSession.setAttribute("gameId", game.getId());

		 log.info("new game id: " + httpSession.getAttribute("gameId")+ " stored in session" );

		 return game;
    }
	 
	    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Game> getGamesToJoin() {
	        return gameService.getGamesToJoin(playerService.getLoggedUser());
	    }

	    @PostMapping(value = "/join")
	    public Game joinGame(@RequestBody GameDTO gameDTO) {
	        Game game = gameService.joinGame(playerService.getLoggedUser(), gameDTO);
	        return game;
	    }


	    @GetMapping(value = "/player/list", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Game> getPlayerGames() {
	        return gameService.getPlayerGames(playerService.getLoggedUser());
	    }

	    @GetMapping(value = "/{id}")
	    public Game getGameProperties(@PathVariable Long id) {

	        httpSession.setAttribute("gameId", id);

	        return gameService.getGame(id);
	    }
}
