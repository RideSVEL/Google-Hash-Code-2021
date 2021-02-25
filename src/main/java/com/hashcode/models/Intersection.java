package com.hashcode.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Data
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Intersection {

  Integer id;
  ArrayList<Street> in;
  ArrayList<Street> out;

  public Intersection(Integer id) {
    this.id = id;
    this.in = new ArrayList<>();
    this.out = new ArrayList<>();
  }
}
