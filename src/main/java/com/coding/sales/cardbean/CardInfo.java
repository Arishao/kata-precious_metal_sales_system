package com.coding.sales.cardbean;

public class CardInfo {

    private CardTypes types;
    private int minPoint;
    private int maxPoint;
    private int currentPoint;
    private String cardId;

    public CardTypes getTypes() {
        return types;
    }

    public void setTypes(CardTypes types) {
        this.types = types;
    }

    public int getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(int minPoint) {
        this.minPoint = minPoint;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
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
}
