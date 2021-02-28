package com.hashcode.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Intersection {

    int id;
    List<Street> in;
    List<Street> out;

    public Intersection(Integer id) {
        this.id = id;
        this.in = new ArrayList<>();
        this.out = new ArrayList<>();
    }
}
