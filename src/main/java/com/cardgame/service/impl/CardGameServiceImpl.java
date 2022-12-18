package com.cardgame.service.impl;

import com.cardgame.model.*;
import com.cardgame.service.CardGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.OK;

@Service
public class CardGameServiceImpl implements CardGameService {

    private BigDecimal balance;
    private Deck deck;
    private Card clientCard;

    @Override
    public ResponseEntity<GameState> startGame(StartGameModelDto startGameModelDto) {

        deck = new Deck();
        balance = startGameModelDto.getStartingBalance();
        clientCard = deck.drawingACard();

        GameState gameState = new GameState();

        setCurrentStateOfClientCardAndBalance(gameState);

        return ResponseEntity.status(OK).body(gameState);
    }

    @Override
    public ResponseEntity<GameState> shuffleDeck() {

        deck = new Deck();
        clientCard = deck.drawingACard();

        GameState gameState = new GameState();

        setCurrentStateOfClientCardAndBalance(gameState);
        gameState.setMessage("The deck shuffled!");
        return ResponseEntity.status(OK).body(gameState);
    }

    @Override
    public ResponseEntity<GameState> bet(BetModelDto betModelDto) {

        BigDecimal currentBet = betModelDto.getBetMoney();
        GameState gameState = new GameState();

        if (currentBet.compareTo(balance) > 0) {
            gameState.setMessage("Not enough balance in your account!");

            setCurrentStateOfClientCardAndBalance(gameState);

            return ResponseEntity.status(OK).body(gameState);
        }

        if (deck.getDeck().isEmpty()) {
            return shuffleDeck();
        }

        Card dealerCard = deck.drawingACard();

        updateBetState(dealerCard,betModelDto.getBetForCard(),currentBet,gameState);

        setCurrentStateOfClientCardAndBalance(gameState);

        gameState.setDealerCard(dealerCard);

        return ResponseEntity.status(OK).body(gameState);
    }

    private void updateBetState(Card dealerCard, int expectedCardState, BigDecimal currentBet, GameState gameState){
        if (clientCard.compareTo(dealerCard) > 0 && expectedCardState > 0 ||
                clientCard.compareTo(dealerCard) < 0 && expectedCardState < 0) {
            BigDecimal win = currentBet.multiply(new BigDecimal(2));
            balance = balance.add(win);
            gameState.setMessage("You win!");
        } else if (clientCard.compareTo(dealerCard) == 0) {
            gameState.setMessage("Еquality!");
        } else {
            balance = balance.subtract(currentBet);
            gameState.setMessage("Dealer win!");
        }
    }

    private void setCurrentStateOfClientCardAndBalance(GameState gameState) {
        gameState.setCurrentBalance(balance);
        gameState.setCard(clientCard);
    }
}
