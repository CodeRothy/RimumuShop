package com.rimumu.shop.repository;

import com.rimumu.shop.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);

    // 썸네일 이미지 찾기
    ItemImg findByItemIdAndRepImgYn(Long itemId, String repImgYn);


}
