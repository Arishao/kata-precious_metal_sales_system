package com.coding.sales.discount;

public enum DiscountRoll {
    /**
     * 9折
     */
    TEN_OFF("9折券"),

    /**
     * 95折
     */
    FIVE_OFF("95折券");

    private String message;

    DiscountRoll(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
