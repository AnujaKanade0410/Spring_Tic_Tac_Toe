package com.an.springboot_tictactoe.dto;

import com.an.springboot_tictactoe.enums.GameType;
import com.an.springboot_tictactoe.enums.Piece;

import lombok.Data;

@Data
public class GameDTO {
	 private int id;
	 private GameType gameType;
	 private Piece piece;
}
