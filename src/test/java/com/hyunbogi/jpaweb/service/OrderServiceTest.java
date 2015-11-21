package com.hyunbogi.jpaweb.service;

import com.hyunbogi.jpaweb.domain.Book;
import com.hyunbogi.jpaweb.domain.Item;
import com.hyunbogi.jpaweb.domain.Member;
import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.OrderStatus;
import com.hyunbogi.jpaweb.domain.embeddable.Address;
import com.hyunbogi.jpaweb.exception.NotEnoughStockException;
import com.hyunbogi.jpaweb.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appConfig.xml")
public class OrderServiceTest {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    public void order() {
        Member member = createMember();
        Item item = createBook("Country JPA", 10000, 10);
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        Order order = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, order.getStatus());
        assertEquals(1, order.getOrderItems().size());
        assertEquals(10000 * 2, order.getTotalPrice());
        assertEquals(8, item.getStockQuantity());
    }

    @Test(expected = NotEnoughStockException.class)
    @Transactional
    public void orderOverStockQuantity() {
        Member member = createMember();
        Item item = createBook("Country JPA", 10000, 10);
        int orderCount = 11;

        orderService.order(member.getId(), item.getId(), orderCount);
        fail("Must throw exception");
    }

    @Test
    @Transactional
    public void cancelOrder() {
        Member member = createMember();
        Item item = createBook("Country JPA", 10000, 10);
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        orderService.cancelOrder(orderId);

        Order order = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, order.getStatus());
        assertEquals(10, item.getStockQuantity());
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("Hyunbok Lee");
        member.setAddress(new Address("Seoul", "Gangnamgu", "123-123"));
        em.persist(member);

        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);

        return book;
    }
}
