package com.coding.sales.userben;

import com.coding.sales.cardbean.CardInfo;

public class UserBean {
    private String name;
    private CardInfo cardInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }
}
