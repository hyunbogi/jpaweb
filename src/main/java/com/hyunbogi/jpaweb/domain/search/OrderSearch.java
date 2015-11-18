package com.hyunbogi.jpaweb.domain.search;

import com.hyunbogi.jpaweb.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * 주문 검색 조건 클래스
 */
public class OrderSearch {
    @Getter
    @Setter
    private String memberName;

    @Getter
    @Setter
    private OrderStatus orderStatus;
}
