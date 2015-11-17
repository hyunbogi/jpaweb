package com.hyunbogi.jpaweb.domain;

import com.hyunbogi.jpaweb.domain.embeddable.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    @Getter
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @Getter
    @Setter
    private String name;

    @Embedded
    @Getter
    @Setter
    private Address address;

    @OneToMany(mappedBy = "member")
    @Getter
    private List<Order> orders = new ArrayList<>();
}
