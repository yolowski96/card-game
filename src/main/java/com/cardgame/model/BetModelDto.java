package com.cardgame.model;

import java.math.BigDecimal;

public class BetModelDto {

    private BigDecimal betMoney;
    private Integer betForCard;

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public Integer getBetForCard() {
        return betForCard;
    }
}
