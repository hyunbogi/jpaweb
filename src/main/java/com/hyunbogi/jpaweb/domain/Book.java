package com.hyunbogi.jpaweb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@ToString
public class Book extends Item {
    @Column(name = "author")
    @Getter
    @Setter
    private String author;

    @Column(name = "isbn")
    @Getter
    @Setter
    private String isbn;
}
