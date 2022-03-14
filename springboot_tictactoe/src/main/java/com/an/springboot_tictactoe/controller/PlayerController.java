package com.an.springboot_tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.springboot_tictactoe.dto.PlayerDTO;
import com.an.springboot_tictactoe.entity.Player;
import com.an.springboot_tictactoe.service.PlayerService;
import com.an.springboot_tictactoe.service.Response;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @PostMapping(value = "/create")
    public Player createAccount(@RequestBody PlayerDTO newPlayerDTO) {
        Player newPlayer = playerService.createNewPlayer(newPlayerDTO);
        return newPlayer;
    }

    @GetMapping(value = "/players")
    public void getPlayers() {
        playerService.listPlayers();}

    @GetMapping(value = "/logged", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Player> getLoggedPlayer() {
        return new Response<>(playerService.getLoggedUser(), Response.Status.CREATED );
    }


}
