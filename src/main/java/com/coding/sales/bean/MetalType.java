package com.coding.sales.bean;

import com.coding.sales.discount.DiscountRoll;
import com.coding.sales.discount.FullReduction;

public class MetalType extends BaseNoblemetal {

    private DiscountRoll discountRoll;

    private FullReduction[] fullReductions;

    public DiscountRoll getDiscountRoll() {
        return discountRoll;
    }

    public void setDiscountRoll(DiscountRoll discountRoll) {
        this.discountRoll = discountRoll;
    }

    public FullReduction[] getFullReductions() {
        return fullReductions;
    }

    public void setFullReductions(FullReduction[] fullReductions) {
        this.fullReductions = fullReductions;
    }
}
