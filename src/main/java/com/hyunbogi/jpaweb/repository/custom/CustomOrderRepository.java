package com.hyunbogi.jpaweb.repository.custom;

import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.search.OrderSearch;

import java.util.List;

public interface CustomOrderRepository {
    List<Order> search(OrderSearch orderSearch);
}
