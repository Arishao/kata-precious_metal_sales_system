package com.coding.sales;

import com.coding.sales.cardbean.CardInfo;
import com.coding.sales.cardbean.CardTypes;
import com.coding.sales.metalbean.IPrice;
import com.coding.sales.contants.Contants;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;
import com.coding.sales.userben.UserBean;
import com.coding.sales.utils.ConvertUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);

        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;

        /**
         * 获取到订单的 商品信息
         */
        List<OrderItemCommand> orderList = command.getItems();

        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
        List<DiscountItemRepresentation> discounts = new ArrayList<DiscountItemRepresentation>();
        BigDecimal totlePrice = new BigDecimal(0);
        BigDecimal totleDiscount = new BigDecimal(0);

        for (int i = 0; i < orderList.size(); i++) {
            OrderItemCommand itemCommand = orderList.get(i);
            IPrice iPrice = Contants.metalTypeMap.get(itemCommand.getProduct());

            OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(iPrice.getOrderId(), iPrice.getProduceName(),
                    iPrice.getPrice(), itemCommand.getAmount(), itemCommand.getAmount().multiply(iPrice.getPrice()));

            orderItems.add(orderItemRepresentation);

            if (iPrice.getDiscountPrice(itemCommand.getAmount()).compareTo(new BigDecimal(0)) > 0) {
                DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(itemCommand.getProduct(), iPrice.getProduceName(), iPrice.getDiscountPrice(itemCommand.getAmount()));
                discounts.add(discountItemRepresentation);
            }

            totlePrice = totlePrice.add(iPrice.getTotalPrice(itemCommand.getAmount()));
            totleDiscount = totleDiscount.add(iPrice.getDiscountPrice(itemCommand.getAmount()));

        }

        UserBean userBean = Contants.userBeanMap.get(command.getMemberId());
        CardInfo cardInfo = userBean.getCardInfo();
        CardTypes newCardType = cardInfo.getNewTypes(totlePrice.subtract(totleDiscount));
        try {
            result = new OrderRepresentation(command.getOrderId(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(command.getCreateTime()), command.getMemberId(), userBean.getName(),
                    userBean.getCardInfo().getTypes().getMessage(), newCardType.getMessage(), cardInfo.getNewPoint(totlePrice.subtract(totleDiscount)),
                    cardInfo.getCurrentPoint(), orderItems, totlePrice, discounts, totleDiscount, totlePrice.subtract(totleDiscount), ConvertUtils.getPayments(command.getPayments()), command.getDiscounts());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //TODO: 请完成需求指定的功能

        return result;
    }

}
