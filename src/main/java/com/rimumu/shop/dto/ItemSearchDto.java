package com.rimumu.shop.dto;

import com.rimumu.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery ="";

    // MainItemDto 처럼 @QueryProjection 으로 변경경
}
