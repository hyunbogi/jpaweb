package com.hyunbogi.jpaweb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    @Getter
    @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    @Getter
    @Setter
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    @Getter
    @Setter
    private Order order;

    @Column(name = "order_price")
    @Getter
    @Setter
    private int orderPrice;

    @Column(name = "count")
    @Getter
    @Setter
    private int count;

    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);

        return orderItem;
    }

    /**
     * 주문을 취소한다.
     */
    public void cancel() {
        getItem().addStock(count);
    }

    /**
     * 주문 삼품 전체 가격을 조회한다.
     *
     * @return 주문 상품 전체 가격
     */
    public int getTotalPrice() {
        return getOrderPrice() * count;
    }
}
