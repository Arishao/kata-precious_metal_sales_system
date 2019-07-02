package com.coding.sales.metalbean;

import java.math.BigDecimal;

public interface IPrice {
    BigDecimal getDiscountPrice(BigDecimal amount);
    BigDecimal getTotalPrice(BigDecimal amount);
    String getProduceName();
    String getOrderId();
    String getUnit();
    BigDecimal getPrice();
}
