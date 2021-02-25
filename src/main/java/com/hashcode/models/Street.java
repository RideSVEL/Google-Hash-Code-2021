package com.hashcode.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Street {
  String name;

  Integer timeOnTrafficLight;

  Integer startIntersection;

  Integer endIntersection;

}
