package com.coding.sales.productutils;

import com.coding.sales.contants.Contants;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metalbean.IPrice;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;

import java.math.BigDecimal;
import java.util.*;

public class Product {
    private OrderCommand orderCommand;
    private List<OrderItemCommand> orderList;

    public Product(OrderCommand orderCommand) {
        this.orderCommand = orderCommand;
        this.orderList = orderCommand.getItems();
    }

    public List<OrderItemRepresentation> getOrderItems() {
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();

        for (int i = 0; i < orderList.size(); i++) {
            OrderItemCommand itemCommand = orderList.get(i);
            IPrice iPrice = Contants.metalTypeMap.get(itemCommand.getProduct());

            OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(iPrice.getOrderId(), iPrice.getProduceName(),
                    iPrice.getPrice(), itemCommand.getAmount(), itemCommand.getAmount().multiply(iPrice.getPrice()));

            orderItems.add(orderItemRepresentation);
        }
        return orderItems;
    }

    public List<DiscountItemRepresentation> getDiscountItem() {
        List<DiscountItemRepresentation> discounts = new ArrayList<DiscountItemRepresentation>();

        for (int i = 0; i < orderList.size(); i++) {
            OrderItemCommand itemCommand = orderList.get(i);
            IPrice iPrice = Contants.metalTypeMap.get(itemCommand.getProduct());

            if (iPrice.getDiscountPrice(itemCommand.getAmount(), orderCommand.getDiscounts()).compareTo(new BigDecimal(0)) > 0) {
                DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(itemCommand.getProduct(), iPrice.getProduceName(), iPrice.getDiscountPrice(itemCommand.getAmount(), orderCommand.getDiscounts()));
                discounts.add(discountItemRepresentation);
            }
        }
        return discounts;
    }

    /**
     * 总价格
     * @return
     */
    public BigDecimal getTotlePrice() {
        BigDecimal totlePrice = new BigDecimal(0);
        for (int i = 0; i < orderList.size(); i++) {
            OrderItemCommand itemCommand = orderList.get(i);
            IPrice iPrice = Contants.metalTypeMap.get(itemCommand.getProduct());

            totlePrice = totlePrice.add(iPrice.getTotalPrice(itemCommand.getAmount()));

        }
        return totlePrice;
    }

    /**
     * 总优惠
     * @return
     */
    public BigDecimal getTotleDiscount() {
        BigDecimal totleDiscount = new BigDecimal(0);
        for (int i = 0; i < orderList.size(); i++) {
            OrderItemCommand itemCommand = orderList.get(i);
            IPrice iPrice = Contants.metalTypeMap.get(itemCommand.getProduct());

            totleDiscount = totleDiscount.add(iPrice.getDiscountPrice(itemCommand.getAmount(), orderCommand.getDiscounts()));

        }
        return totleDiscount;
    }

    /**
     * 实际应付金额
     * @return
     */
    public BigDecimal getDealPrice() {
       return getTotlePrice().subtract(getTotleDiscount());
    }

    public List<String> getDiscounts(Map<String, String> map) {
        List<String> discounts = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            discounts.add(entry.getValue());
        }
        return discounts;
    }

}
