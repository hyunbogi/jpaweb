package com.hyunbogi.jpaweb.service.impl;

import com.hyunbogi.jpaweb.domain.Delivery;
import com.hyunbogi.jpaweb.domain.Item;
import com.hyunbogi.jpaweb.domain.Member;
import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.OrderItem;
import com.hyunbogi.jpaweb.domain.search.OrderSearch;
import com.hyunbogi.jpaweb.repository.MemberRepository;
import com.hyunbogi.jpaweb.repository.OrderRepository;
import com.hyunbogi.jpaweb.service.ItemService;
import com.hyunbogi.jpaweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

    @Override
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemService.findOne(itemId);

        Delivery delivery = new Delivery(member.getAddress());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);

        return order.getId();
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch.toSpecification());
    }
}
