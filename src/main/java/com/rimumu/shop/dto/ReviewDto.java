package com.rimumu.shop.dto;


import com.rimumu.shop.entity.Item;
import com.rimumu.shop.entity.Member;
import com.rimumu.shop.entity.OrderItem;
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

    public ReviewDto(ReviewDto reviewDto, Item item, Member member) {

        this.reviewId = reviewDto.reviewId;



    }

}
