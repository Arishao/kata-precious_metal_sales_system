package com.coding.sales.metalbean;

import com.coding.sales.contants.Contants;
import com.coding.sales.discount.DiscountRoll;

import java.math.BigDecimal;
import java.util.List;

public class Three implements IPrice {

    private static final String produceName = "招财进宝";
    private static final String orderId = "003001";
    private static final String unit = "条";
    private static final BigDecimal price = new BigDecimal(1580.00);
    private static final DiscountRoll discountRoll = DiscountRoll.FIVE_OFF;

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount, List<String> discounts) {

        if (discounts.contains(discountRoll.getMessage())) {
            Contants.discounts.put(discountRoll.getMessage(), discountRoll.getMessage());
            return getTotalPrice(amount).multiply(new BigDecimal(0.05));

        } else {
            return new BigDecimal(0);
        }
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
