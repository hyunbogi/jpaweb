package com.hyunbogi.jpaweb.domain;

import com.hyunbogi.jpaweb.domain.embeddable.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    @Getter
    private Long id;

    @OneToOne(mappedBy = "delivery")
    @Getter
    @Setter
    private Order order;

    @Embedded
    @Getter
    @Setter
    private Address address;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private DeliveryStatus status;
}
