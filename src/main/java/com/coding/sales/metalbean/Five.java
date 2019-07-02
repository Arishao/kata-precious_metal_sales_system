package com.coding.sales.metalbean;

import com.coding.sales.discount.FullReduction;

import java.math.BigDecimal;

public class Five implements IPrice {
    private static final String produceName = "中国经典钱币套装";
    private static final String orderId = "002002";
    private static final String unit = "套";
    private static final BigDecimal price = new BigDecimal(998.00);
    private static final FullReduction[] fullReductions = new FullReduction[]{FullReduction.FULL_2000_REDUCE_30, FullReduction.FUll_1000_REDUCE_10};

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount) {
        BigDecimal discountPrice = new BigDecimal(0);
        if(getTotalPrice(amount).compareTo(new BigDecimal(2000)) >= 0) {
            discountPrice = new BigDecimal(30);
        } else if (getTotalPrice(amount).compareTo(new BigDecimal(1000)) >= 0) {
            discountPrice = new BigDecimal(10);
        }
        return discountPrice;
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
