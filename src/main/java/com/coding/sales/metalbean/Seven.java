package com.coding.sales.metalbean;

import com.coding.sales.discount.DiscountRoll;
import com.coding.sales.discount.FullReduction;

import java.math.BigDecimal;

public class Seven implements IPrice {

    private static final String produceName = "中国银象棋12g";
    private static final String orderId = "002003";
    private static final String unit = "套";
    private static final BigDecimal price = new BigDecimal(698.00);
    private static final FullReduction[] fullReductions = new FullReduction[]{FullReduction.FULL_3000_REDUCE_350, FullReduction.FULL_2000_REDUCE_30, FullReduction.FUll_1000_REDUCE_10};
    private static final DiscountRoll discountRoll = DiscountRoll.TEN_OFF;

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount) {
        BigDecimal discountPrice = new BigDecimal(0);
        if(getTotalPrice(amount).compareTo(new BigDecimal(3000)) >= 0) {
            discountPrice = new BigDecimal(350);
        } else if(getTotalPrice(amount).compareTo(new BigDecimal(2000)) >= 0) {
            discountPrice = new BigDecimal(30);
        } else if (getTotalPrice(amount).compareTo(new BigDecimal(1000)) >= 0) {
            discountPrice = new BigDecimal(10);
        }

        BigDecimal discountPrice1 = getTotalPrice(amount).multiply(new BigDecimal(0.1));

        if(discountPrice.compareTo(discountPrice1) >= 0) {
            return discountPrice;
        } else {
            return discountPrice1;
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
