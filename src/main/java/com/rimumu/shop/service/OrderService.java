package com.rimumu.shop.service;

import com.rimumu.shop.dto.OrderDto;
import com.rimumu.shop.entity.Item;
import com.rimumu.shop.entity.Member;
import com.rimumu.shop.entity.Order;
import com.rimumu.shop.entity.OrderItem;
import com.rimumu.shop.repository.ItemRepository;
import com.rimumu.shop.repository.MemberRepository;
import com.rimumu.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

// 주문 로직
@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public Long order(OrderDto orderDto, String email) {
        // 주문할 상품 조회
        Item item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        // email 로 주문자 조회회
       Member member = memberRepository.findByEmail(email);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount()); // 주문상품 엔티티 ( 상품 엔티티 + 수량 )
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member, orderItemList); // 주문살 상품 리스트로 주문 엔티티 생성
        orderRepository.save(order); // 주문 엔티티 저장

        return order.getId();
    }

}
