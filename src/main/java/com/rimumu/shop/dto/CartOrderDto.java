package com.rimumu.shop.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 장바구니 상품 주문
@Getter @Setter
public class CartOrderDto {

    private Long cartItemId;

    private List<CartOrderDto> cartOrderDtoList;

}
