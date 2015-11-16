package com.hyunbogi.jpaweb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    @Getter
    @Setter
    private String director;

    @Getter
    @Setter
    private String actor;
}
