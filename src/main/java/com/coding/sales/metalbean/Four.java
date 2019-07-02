package com.coding.sales.metalbean;

import com.coding.sales.discount.FullReduction;

import java.math.BigDecimal;
import java.util.List;

public class Four implements IPrice {
    private static final String produceName = "水晶之恋";
    private static final String orderId = "003002";
    private static final String unit = "条";
    private static final BigDecimal price = new BigDecimal(980.00);
    private static final FullReduction[] fullReductions = new FullReduction[]{FullReduction.THIRD_HALF_PRICE, FullReduction.FULL_THREE_GIVE_1};

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount, List<String> discounts) {
        BigDecimal discountPrice = BigDecimal.valueOf(0);
        if(amount.compareTo(new BigDecimal(3)) < 0) {
            discountPrice = new BigDecimal(0);
        } else if (amount.compareTo(new BigDecimal(3)) == 0) {
            discountPrice = price.divide(new BigDecimal(2));
        } else {
            discountPrice = price;
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
