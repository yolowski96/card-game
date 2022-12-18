package com.cardgame.service;

import com.cardgame.model.BetModelDto;
import com.cardgame.model.StartGameModelDto;
import com.cardgame.model.GameState;
import org.springframework.http.ResponseEntity;

public interface CardGameService {

    ResponseEntity<GameState> startGame(StartGameModelDto startGameModelDto);

    ResponseEntity<GameState> shuffleDeck();

    ResponseEntity<GameState> bet(BetModelDto betModelDto);
}
