package com.cardgame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class GameState {

    private Card card;
    private BigDecimal currentBalance;
    private Card dealerCard;

    private String message;

    public Card getCard() {
        return card;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public Card getDealerCard() {
        return dealerCard;
    }

    public String getMessage() {
        return message;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setDealerCard(Card dealerCard) {
        this.dealerCard = dealerCard;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
