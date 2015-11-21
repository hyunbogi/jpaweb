package com.hyunbogi.jpaweb.domain.search;

import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import static com.hyunbogi.jpaweb.domain.spec.OrderSpec.memberNameLike;
import static com.hyunbogi.jpaweb.domain.spec.OrderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specifications.where;

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

    public Specification<Order> toSpecification() {
        return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
    }
}
