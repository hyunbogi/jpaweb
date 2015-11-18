package com.hyunbogi.jpaweb.service;

import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.search.OrderSearch;

import java.util.List;

public interface OrderService {
    /**
     * 상품을 주문한다.
     *
     * @param memberId 주문자 ID
     * @param itemId   상품 ID
     * @param count    상품 개수
     * @return 주문 ID
     */
    Long order(Long memberId, Long itemId, int count);

    /**
     * 주문을 취소한다.
     *
     * @param orderId 주문 ID
     */
    void cancelOrder(Long orderId);

    /**
     * 검색 조건에 맞는 주문을 조회한다.
     *
     * @param orderSearch 검색 조건
     * @return 주문 정보
     */
    List<Order> findOrders(OrderSearch orderSearch);
}
