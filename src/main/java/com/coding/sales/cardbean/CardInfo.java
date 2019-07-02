package com.coding.sales.cardbean;

import java.math.BigDecimal;

public class CardInfo {

    private CardTypes types;
    private int currentPoint;
    private String cardId;
    private int newPoint;

    public CardTypes getTypes() {
        return types;
    }

    public void setTypes(CardTypes types) {
        this.types = types;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getNewPoint(BigDecimal newPoint) {
        return types.getCode().multiply(newPoint).setScale(2, BigDecimal.ROUND_UP).intValue();
    }

    public CardTypes getNewTypes(BigDecimal points) {
        CardTypes newTypes;
        newPoint = types.getCode().multiply(points).setScale(2, BigDecimal.ROUND_UP).intValue();
        int point = currentPoint + newPoint;
        if (point >= 100000) {
            newTypes = CardTypes.DIAMOND;
        } else if (point >= 50000) {
            newTypes = CardTypes.PLATINUM;
        } else if (point >= 10000) {
            newTypes = CardTypes.GOLDEN;
        } else {
            newTypes = CardTypes.NORMAL;
        }
        currentPoint = point;
        return newTypes;
    }
}
