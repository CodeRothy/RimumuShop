package com.rimumu.shop.dto;

import com.rimumu.shop.entity.Item;
import com.rimumu.shop.entity.Review;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDto {

    private Long reviewId;

    private String review;

//    private String heart;

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

    public ReviewDto(Long reviewId, String review, String memberName) {
        this.reviewId = reviewId;
        this.review = review;
//        this.heart = heart;
        this.memberName = memberName;
        this.createdDate = LocalDateTime.now();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public Review createReview(String memberName) {
        setMemberName(memberName);
        return modelMapper.map(this, Review.class);
    }


}
