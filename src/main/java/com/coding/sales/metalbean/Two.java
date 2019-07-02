package com.coding.sales.metalbean;

import com.coding.sales.contants.Contants;
import com.coding.sales.discount.DiscountRoll;

import java.math.BigDecimal;
import java.util.List;

public class Two implements IPrice {

    private static final String produceName = "2019北京世园会纪念银章大全40g";
    private static final String orderId = "001002";
    private static final String unit = "盒";
    private static final BigDecimal price = new BigDecimal(1380.00);
    private static final DiscountRoll discountRoll = DiscountRoll.TEN_OFF;

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount, List<String> discounts) {
        if (discounts.contains(discountRoll.getMessage())) {
            Contants.discounts.put(discountRoll.getMessage(), discountRoll.getMessage());
            return getTotalPrice(amount).multiply(new BigDecimal(0.1));

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
