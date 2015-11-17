package com.hyunbogi.jpaweb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    @Column(name = "artist")
    @Getter
    @Setter
    private String artist;

    @Column(name = "etc")
    @Getter
    @Setter
    private String etc;
}
