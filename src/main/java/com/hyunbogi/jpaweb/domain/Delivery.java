package com.hyunbogi.jpaweb.domain;

import com.hyunbogi.jpaweb.domain.embeddable.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
@NoArgsConstructor
@ToString
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    @Getter
    @Setter
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
    @Column(name = "status")
    @Getter
    @Setter
    private DeliveryStatus status;

    public Delivery(Address address) {
        this.address = address;
        status = DeliveryStatus.READY;
    }
}
