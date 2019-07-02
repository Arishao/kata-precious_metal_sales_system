package com.coding.sales.metalbean;

import java.math.BigDecimal;

public class One implements IPrice{

    private static final String produceName = "世园会五十国钱币册";
    private static final String orderId = "001001";
    private static final String unit = "册";
    private static final BigDecimal price = new BigDecimal(998.00);

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount) {
        return new BigDecimal(0);
    }

    @Override
    public BigDecimal getTotalPrice(BigDecimal amount) {
        return price.multiply(amount);
    }

    @Override
    public String getProduceName() {
        return produceName;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
