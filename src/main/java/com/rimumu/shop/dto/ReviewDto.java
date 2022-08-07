package com.rimumu.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDto {

    private Long reviewId;

    private String review;

    private String memberName;

    private LocalDateTime createdDate;

//    @QueryProjection
//    public MainItemDto(Long id, String itemNm, String itemNmEng, String itemDetail, String imgUrl,Integer price){
//        this.id = id;
//        this.itemNm = itemNm;
//        this.itemNmEng = itemNmEng;
//        this.itemDetail = itemDetail;
//        this.imgUrl = imgUrl;
//        this.price = price;
//    }

}
