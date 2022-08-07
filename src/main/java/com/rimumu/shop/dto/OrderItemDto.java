package com.rimumu.shop.dto;

import com.rimumu.shop.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDto {


    private String itemNm; // 상품명

    private int count;

    private int orderPrice; // 주문금액

    private String imgUrl;


    public OrderItemDto(OrderItem orderItem, String imgUrl) {

        this.itemNm = orderItem.getItem().getItemNm();
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;


    }

}
