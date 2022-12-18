package com.cardgame.controller;

import com.cardgame.model.BetModelDto;
import com.cardgame.model.StartGameModelDto;
import com.cardgame.model.GameState;
import com.cardgame.service.CardGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
public class CardGameController {

    private final CardGameService cardGameService;

    public CardGameController(CardGameService cardGameService) {
        this.cardGameService = cardGameService;
    }

    /**
     * Returns new card from the deck and current balance of the user.
     *
     * @header Content-Type    application/json
     * expected body model: { "startingBalance": ... }
     *
     * @return The object GameState
     */
    @PostMapping("/start")
    public ResponseEntity<GameState> startGame(@RequestBody StartGameModelDto startGameModelDto){
        return cardGameService.startGame(startGameModelDto);
    }

    /**
     * Returns new deck and new card for the user
     *
     * @header Content-Type    application/json
     *
     * @return The object GameState
     */
    @GetMapping("/shuffle")
    public ResponseEntity<GameState> shuffleDeck(){
        return cardGameService.shuffleDeck();
    }

    /**
     * Returns current state of the game
     *
     * @header Content-Type    application/json
     * expected body model: { "betMoney": ... , "betForCard": -1 or 1 }
     *
     * @return The object GameState
     */
    @PostMapping("/bet")
    public ResponseEntity<GameState> bet(@RequestBody BetModelDto betModelDto){
        return cardGameService.bet(betModelDto);
    }
}
