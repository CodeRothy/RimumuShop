package com.rimumu.shop.repository;

import com.rimumu.shop.dto.ItemSearchDto;

import com.rimumu.shop.dto.MainItemDto;
import com.rimumu.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    // ItemSearchDto 6.3장
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    // MainItemDto 6.4장
    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}
