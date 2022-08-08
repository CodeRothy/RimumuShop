package com.rimumu.shop.controller;

import com.rimumu.shop.dto.ReviewDto;
import com.rimumu.shop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 등록
    @PostMapping(value = "/item/{itemId}/review")
    public ResponseEntity reviewSave(@PathVariable("itemId") Long id, @RequestBody ReviewDto reviewDto, Principal principal, Model model) {

        String email = principal.getName();
        return ResponseEntity.ok(reviewService.reviewSave(reviewDto,email,id));

    }

}
