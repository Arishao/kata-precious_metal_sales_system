package com.coding.sales.contants;

import com.coding.sales.bean.MetalType;
import com.coding.sales.cardbean.CardInfo;
import com.coding.sales.cardbean.CardTypes;
import com.coding.sales.discount.DiscountRoll;
import com.coding.sales.discount.FullReduction;
import com.coding.sales.userben.UserBean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Contants {
    /**
     * 用户信息
     */
    private static UserBean userBean;
    private static UserBean userBean1;
    private static UserBean userBean2;
    private static UserBean userBean3;

    static {
        userBean = new UserBean();
        userBean.setName("马丁");
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardId("6236609999");
        cardInfo.setCurrentPoint(9860);
        cardInfo.setMaxPoint(10000);
        cardInfo.setMinPoint(0);
        cardInfo.setTypes(CardTypes.NORMAL);
        userBean.setCardInfo(cardInfo);

        userBean1 = new UserBean();
        userBean1.setName("王立");
        CardInfo cardInfo1 = new CardInfo();
        cardInfo1.setCardId("6630009999");
        cardInfo1.setCurrentPoint(48860);
        cardInfo1.setMaxPoint(50000);
        cardInfo1.setMinPoint(10000);
        cardInfo1.setTypes(CardTypes.GOLDEN);
        userBean1.setCardInfo(cardInfo1);

        userBean2 = new UserBean();
        userBean2.setName("李想");
        CardInfo cardInfo2 = new CardInfo();
        cardInfo2.setCardId("8230009999");
        cardInfo2.setCurrentPoint(98860);
        cardInfo2.setMaxPoint(100000);
        cardInfo2.setMinPoint(50000);
        cardInfo2.setTypes(CardTypes.PLATINUM);
        userBean2.setCardInfo(cardInfo2);

        userBean3 = new UserBean();
        userBean3.setName("张三");
        CardInfo cardInfo3 = new CardInfo();
        cardInfo3.setCardId("9230009999");
        cardInfo3.setCurrentPoint(198860);
        cardInfo3.setMinPoint(100000);
        cardInfo3.setTypes(CardTypes.DIAMOND);
        userBean3.setCardInfo(cardInfo3);
    }

    /**
     * 商品列表
     */

    private static MetalType metalType;
    private static MetalType metalType1;
    private static MetalType metalType2;
    private static MetalType metalType3;
    private static MetalType metalType4;
    private static MetalType metalType5;
    private static MetalType metalType6;

    static {
        metalType = new MetalType();
        metalType.setOrderId("001001");
        metalType.setPrice(new BigDecimal(998.00));
        metalType.setUnit("册");

        metalType1 = new MetalType();
        metalType1.setOrderId("001002");
        metalType1.setPrice(new BigDecimal(1380.00));
        metalType1.setUnit("盒");
        metalType1.setDiscountRoll(DiscountRoll.TEN_OFF);

        metalType2 = new MetalType();
        metalType2.setOrderId("003001");
        metalType2.setPrice(new BigDecimal(1580.00));
        metalType2.setUnit("条");
        metalType2.setDiscountRoll(DiscountRoll.FIVE_OFF);

        metalType3 = new MetalType();
        metalType3.setOrderId("003002");
        metalType3.setPrice(new BigDecimal(980.00));
        metalType3.setUnit("条");
        metalType3.setFullReductions(new FullReduction[]{FullReduction.THIRD_HALF_PRICE, FullReduction.FULL_THREE_GIVE_1});

        metalType4 = new MetalType();
        metalType4.setOrderId("002002");
        metalType4.setPrice(new BigDecimal(998.00));
        metalType4.setUnit("套");
        metalType4.setFullReductions(new FullReduction[]{FullReduction.FULL_2000_REDUCE_30, FullReduction.FUll_1000_REDUCE_10});

        metalType5 = new MetalType();
        metalType5.setOrderId("002001");
        metalType5.setPrice(new BigDecimal(1080.00));
        metalType5.setUnit("条");
        metalType5.setDiscountRoll(DiscountRoll.FIVE_OFF);
        metalType5.setFullReductions(new FullReduction[]{FullReduction.THIRD_HALF_PRICE, FullReduction.FULL_THREE_GIVE_1});

        metalType6 = new MetalType();
        metalType6.setOrderId("002003");
        metalType6.setPrice(new BigDecimal(698.00));
        metalType6.setUnit("套");
        metalType6.setDiscountRoll(DiscountRoll.TEN_OFF);
        metalType6.setFullReductions(new FullReduction[]{FullReduction.FULL_3000_REDUCE_350, FullReduction.FULL_2000_REDUCE_30, FullReduction.FUll_1000_REDUCE_10});
    }



    public static Map<String, UserBean> userBeanMap = new HashMap<String, UserBean>(){{
        put("6236609999", userBean);
        put("6630009999", userBean1);
        put("8230009999", userBean2);
        put("9230009999", userBean3);
    }};


    public static Map<String, MetalType> metalTypeMap = new HashMap<String, MetalType>() {{
        put("001001", metalType);
        put("001002", metalType1);
        put("003001", metalType2);
        put("003002", metalType3);
        put("002002", metalType4);
        put("002001", metalType5);
        put("002003", metalType6);

    }};
}
