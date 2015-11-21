package com.hyunbogi.jpaweb.repository.custom;

import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.search.OrderSearch;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class OrderRepositoryImpl extends QueryDslRepositorySupport implements CustomOrderRepository {
    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> search(OrderSearch orderSearch) {
        return null;
    }
}
