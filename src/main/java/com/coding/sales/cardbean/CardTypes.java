package com.coding.sales.cardbean;

import java.math.BigDecimal;

public enum CardTypes {

    /**
     * 普卡
     */
    NORMAL(new BigDecimal(1), "普卡"),
    /**
     * 金卡
     */
    GOLDEN(new BigDecimal(1.5), "金卡"),
    /**
     * 白金卡
     */
    PLATINUM(new BigDecimal(1.8), "白金卡"),
    /**
     * 钻石卡
     */
    DIAMOND(new BigDecimal(2), "钻石卡");

    private BigDecimal code;
    private String message;

    CardTypes(BigDecimal code, String message) {
        this.code = code;
        this.message = message;
    }

    public BigDecimal getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
