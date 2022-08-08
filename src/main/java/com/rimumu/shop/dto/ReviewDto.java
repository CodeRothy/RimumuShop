package com.rimumu.shop.dto;

import com.rimumu.shop.entity.Item;
import com.rimumu.shop.entity.Member;
import com.rimumu.shop.entity.Review;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {

    private Long reviewId;

    private String review;

    private String memberName;


    @Builder
    public ReviewDto(String review, String memberName){
        this.review=review;
        this.memberName = memberName;
    }

    public Review toEntity(String memberName, Item item, Member member){

        return Review.builder()
                .review(review)
                .memberName(memberName)
                .item(item)
                .member(member)
                .build();

    }


//    @QueryProjection
//    public MainItemDto(Long id, String itemNm, String itemNmEng, String itemDetail, String imgUrl,Integer price){
//        this.id = id;
//        this.itemNm = itemNm;
//        this.itemNmEng = itemNmEng;
//        this.itemDetail = itemDetail;
//        this.imgUrl = imgUrl;
//        this.price = price;
//    }


//    private static ModelMapper modelMapper = new ModelMapper();
//
//    public Review createReview() {
//        return modelMapper.map(this, Review.class);
//    }


}
