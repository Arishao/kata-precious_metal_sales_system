package com.coding.sales.metalbean;

import com.coding.sales.contants.Contants;
import com.coding.sales.discount.DiscountRoll;
import com.coding.sales.discount.FullReduction;

import java.math.BigDecimal;
import java.util.List;

public class Six implements IPrice {

    private static final String produceName = "守扩之羽比翼双飞4.8g";
    private static final String orderId = "002001";
    private static final String unit = "条";
    private static final BigDecimal price = new BigDecimal(1080.00);
    private static final FullReduction[] fullReductions = new FullReduction[]{FullReduction.THIRD_HALF_PRICE, FullReduction.FULL_THREE_GIVE_1};
    private static final DiscountRoll discountRoll = DiscountRoll.FIVE_OFF;

    @Override
    public BigDecimal getDiscountPrice(BigDecimal amount, List<String> discounts) {
        BigDecimal discountPrice = new BigDecimal(0);
        if(amount.compareTo(new BigDecimal(3)) < 0) {
            discountPrice = new BigDecimal(0);
        } else if (amount.compareTo(new BigDecimal(3)) == 0) {
            discountPrice = price.divide(new BigDecimal(2));
        } else {
            discountPrice = price;
        }

        BigDecimal discountPrice1 = new BigDecimal(0);
        if(discounts.contains(discountRoll.getMessage())) {
            Contants.discounts.put(discountRoll.getMessage(), discountRoll.getMessage());
            discountPrice1 = getTotalPrice(amount).multiply(new BigDecimal(0.05));
        }

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
