package com.hyunbogi.jpaweb.repository;

import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.search.OrderSearch;

import java.util.List;

public interface OrderRepository {
    /**
     * DB에 주문 정보를 저장한다.
     *
     * @param order 주문 정보
     */
    void save(Order order);

    /**
     * DB에서 주문 정보를 조회한다.
     *
     * @param id 주문 ID
     * @return 주문 정보
     */
    Order findOne(Long id);

    /**
     * DB에서 검색 조건에 맞는 주문 정보를 조회한다.
     *
     * @param orderSearch 검색 조건
     * @return 주문 정보
     */
    List<Order> findAll(OrderSearch orderSearch);
}
