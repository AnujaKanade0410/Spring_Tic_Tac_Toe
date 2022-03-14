package com.an.springboot_tictactoe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.an.springboot_tictactoe.entity.Game;
import com.an.springboot_tictactoe.enums.GameStatus;
import com.an.springboot_tictactoe.enums.GameType;

@Repository
public interface GameRepository extends CrudRepository<Game, Long>{
    List<Game> findByGameTypeAndGameStatus(GameType GameType, GameStatus GameStatus);
    List<Game> findByGameStatus(GameStatus gameStatus);
}
