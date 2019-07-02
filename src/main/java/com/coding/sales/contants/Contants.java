package com.coding.sales.contants;

import com.coding.sales.metalbean.*;
import com.coding.sales.cardbean.CardInfo;
import com.coding.sales.cardbean.CardTypes;
import com.coding.sales.userben.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        cardInfo.setTypes(CardTypes.NORMAL);
        userBean.setCardInfo(cardInfo);

        userBean1 = new UserBean();
        userBean1.setName("王立");
        CardInfo cardInfo1 = new CardInfo();
        cardInfo1.setCardId("6630009999");
        cardInfo1.setCurrentPoint(48860);
        cardInfo1.setTypes(CardTypes.GOLDEN);
        userBean1.setCardInfo(cardInfo1);

        userBean2 = new UserBean();
        userBean2.setName("李想");
        CardInfo cardInfo2 = new CardInfo();
        cardInfo2.setCardId("8230009999");
        cardInfo2.setCurrentPoint(98860);
        cardInfo2.setTypes(CardTypes.PLATINUM);
        userBean2.setCardInfo(cardInfo2);

        userBean3 = new UserBean();
        userBean3.setName("张三");
        CardInfo cardInfo3 = new CardInfo();
        cardInfo3.setCardId("9230009999");
        cardInfo3.setCurrentPoint(198860);
        cardInfo3.setTypes(CardTypes.DIAMOND);
        userBean3.setCardInfo(cardInfo3);
    }

    /**
     * 商品列表
     */

    private static One one;
    private static Two two;
    private static Three three;
    private static Four four;
    private static Five five;
    private static Six six;
    private static Seven seven;

    static {
        one = new One();
        two = new Two();
        three = new Three();
        four = new Four();
        five = new Five();
        six = new Six();
        seven = new Seven();
    }

    public static Map<String, UserBean> userBeanMap = new HashMap<String, UserBean>(){{
        put("6236609999", userBean);
        put("6630009999", userBean1);
        put("8230009999", userBean2);
        put("9230009999", userBean3);
    }};


    public static Map<String, IPrice> metalTypeMap = new HashMap<String, IPrice>() {{
        put("001001", one);
        put("001002", two);
        put("003001", three);
        put("003002", four);
        put("002002", five);
        put("002001", six);
        put("002003", seven);

    }};

    public static Map<String, String> discounts = new HashMap<String, String>();
}
