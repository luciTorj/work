package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by internship on 15.09.2016.
 */
@Getter
@Setter
@MappedSuperclass
public class    Base {
    @Id
    @GeneratedValue
    protected long id;
}
