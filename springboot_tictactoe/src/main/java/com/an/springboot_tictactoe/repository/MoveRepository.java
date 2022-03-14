package com.an.springboot_tictactoe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.an.springboot_tictactoe.entity.Game;
import com.an.springboot_tictactoe.entity.Move;
import com.an.springboot_tictactoe.entity.Player;

@Repository
public interface MoveRepository extends CrudRepository<Move, Long> {

    List<Move> findByGame(Game game);
    List<Move> findByGameAndPlayer(Game game, Player player);
    int countByGameAndPlayer(Game game, Player player);
}
