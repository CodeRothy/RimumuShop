package com.rimumu.shop.entity;

import com.rimumu.shop.constant.ItemSellStatus;
import com.rimumu.shop.dto.ItemFormDto;
import com.rimumu.shop.exception.OutOfStockException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "item")
@Getter @Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 상품코드

    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명

    @Column(nullable = false, length = 50)
    private String itemNmEng; // 영어 상품명

    @Column(nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private String category; // 카테고리

    @Column(nullable = false)
    private  int stockNumber; // 재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록시간

    private LocalDateTime updateTime; // 수정시간

    // 리뷰 List
    @OneToMany(mappedBy = "review", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("review_id desc")
    private List<Review> reviewList;


    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    // 주문 시 재고확인
    public void removeStock(int stockNumber) {
        int restStock = this.stockNumber - stockNumber;
        if (restStock < 0) {
            throw new OutOfStockException("상품의 재고가 부족 합니다. ( 현재 재고 수량 : " + this.stockNumber + ")");
        }
        this.stockNumber = restStock;
    }

    // 재고 증가 (주문 취소 시 등)
    public void addStock(int stockNumber) {
        this.stockNumber += stockNumber;
    }

}
