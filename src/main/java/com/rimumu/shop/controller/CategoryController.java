package com.rimumu.shop.controller;

import com.rimumu.shop.entity.Item;
import com.rimumu.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final ItemService itemService;


}
