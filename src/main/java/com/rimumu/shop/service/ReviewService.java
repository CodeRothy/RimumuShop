package com.rimumu.shop.service;

import com.rimumu.shop.entity.Review;
import com.rimumu.shop.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 리스트
    @Transactional(readOnly = true)
    public List<Review> getReviewList(Long itemId){

//        List<Review> reviewList = new ArrayList<>();
        List<Review> reviewList = reviewRepository.findByItemId(itemId);

        return reviewList;

    }

}
