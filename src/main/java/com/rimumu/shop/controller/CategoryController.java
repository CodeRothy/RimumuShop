package com.rimumu.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    @GetMapping("/category/{category}")
    public String category(@PathVariable("category")String category, Model model){

        return "category/category";
    }
}
