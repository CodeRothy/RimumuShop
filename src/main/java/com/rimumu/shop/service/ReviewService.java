package com.rimumu.shop.service;

import com.rimumu.shop.constant.OrderStatus;
import com.rimumu.shop.dto.ReviewDto;
import com.rimumu.shop.entity.*;
import com.rimumu.shop.repository.ItemRepository;
import com.rimumu.shop.repository.MemberRepository;
import com.rimumu.shop.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    // 리뷰 리스트
    @Transactional(readOnly = true)
    public List<Review> getReviewList(Long itemId){

//        List<Review> reviewList = new ArrayList<>();
        List<Review> reviewList = reviewRepository.findByItemId(itemId);

        return reviewList;

    }


    // 리뷰 등록
    public Long reviewSave(ReviewDto reviewDto, String email, Long id){

        Optional<Item> optItem = itemRepository.findById(id);
        optItem.ifPresent(select ->{
            Member member = memberRepository.findByEmail(email);
            String memberName = member.getName();

            reviewRepository.save(reviewDto.toEntity(memberName, select, member));

        });

        return id;
    }



}
