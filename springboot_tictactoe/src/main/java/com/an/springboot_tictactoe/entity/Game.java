package com.an.springboot_tictactoe.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;

import com.an.springboot_tictactoe.enums.GameStatus;
import com.an.springboot_tictactoe.enums.GameType;
import com.an.springboot_tictactoe.enums.Piece;

import lombok.Data;

@Data
@Entity
@Check(constraints = "first_player_piece_code = 'X' " +
        "and game_type = 'COMPUTER' or game_type = 'COMPETITION' " +
        "and game_status = 'IN_PROGRESS' or game_status = 'FIRST_PLAYER_WON' or game_status = 'SECOND_PLAYER_WON'" +
        "or game_status = 'TIE' or game_status = 'WAITS_FOR_PLAYER' ")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "first_player_id", nullable = true)	
	private Player firstPlayer;
	@ManyToOne
	@JoinColumn(name = "second_player_id", nullable = true)		
	private Player secondPlayer;
	
	@Enumerated(EnumType.STRING)
	private Piece firstPlayerPieceCode;

	@Enumerated(EnumType.STRING)
	private GameType gameType;

	@Enumerated(EnumType.STRING)
	private GameStatus gameStatus;

	@Column(name = "created", nullable = false)
	private Date created;
}
