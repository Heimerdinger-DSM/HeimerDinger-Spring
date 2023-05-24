package com.example.heimerdinger.global.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;



@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @Column(nullable = false)
    private final ZonedDateTime CreateAt = ZonedDateTime.now();

}