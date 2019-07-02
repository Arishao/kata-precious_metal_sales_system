package com.coding.sales.discount;

public enum FullReduction {

    /**
     * 每满3000元减350
     */
    FULL_3000_REDUCE_350,
    /**
     * 每满2000元减30
     */
    FULL_2000_REDUCE_30,
    /**
     * 每满1000元减10
     */
    FUll_1000_REDUCE_10,
    /**
     * 第3件半价`（买3件及以上，其中1件半价）
     */
    THIRD_HALF_PRICE,
    /**
     * 满3送1`（买4件及以上，其中1件免费）
     */
    FULL_THREE_GIVE_1;
}
