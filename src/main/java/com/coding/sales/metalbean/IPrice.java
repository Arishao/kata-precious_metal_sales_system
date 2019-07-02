package com.coding.sales.metalbean;

import java.math.BigDecimal;
import java.util.List;

public interface IPrice {
    BigDecimal getDiscountPrice(BigDecimal amount, List<String> discounts);
    BigDecimal getTotalPrice(BigDecimal amount);
    String getProduceName();
    String getOrderId();
    String getUnit();
    BigDecimal getPrice();
}
