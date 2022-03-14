package com.an.springboot_tictactoe.dto;

import java.util.Date;

import com.an.springboot_tictactoe.enums.GameStatus;
import com.an.springboot_tictactoe.enums.Piece;

import lombok.Data;

@Data
public class MoveDTO {
	 private int boardColumn;
	 private int boardRow;
	 private Date created;
	 private String userName;
	 private GameStatus gameStatus;
	 private Piece playerPieceCode;
}
