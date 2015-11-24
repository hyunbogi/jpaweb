package com.hyunbogi.jpaweb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    @Getter
    @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    @Getter
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @Getter
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    @Getter
    private Delivery delivery;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    @Getter
    @Setter
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Getter
    @Setter
    private OrderStatus status;

    /**
     * Factory method
     */
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.ORDER);

        return order;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    /**
     * 주문을 취소한다.
     */
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new RuntimeException("Unable to cancel the order");
        }
        setStatus(OrderStatus.CANCEL);
        orderItems.forEach(OrderItem::cancel);
    }

    /**
     * 전체 주문 가격을 조회한다.
     *
     * @return 전체 주문 가격
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }

        return totalPrice;
    }
}
