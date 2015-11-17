package com.hyunbogi.jpaweb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    @Column(name = "director")
    @Getter
    @Setter
    private String director;

    @Column(name = "actor")
    @Getter
    @Setter
    private String actor;
}
