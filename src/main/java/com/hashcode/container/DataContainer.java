package com.hashcode.container;

import com.hashcode.models.Car;
import com.hashcode.models.Intersection;
import com.hashcode.models.Street;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.IntStream;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataContainer {

    int durationD;
    int intersectionsI;
    int streetsSCounts;
    int carsV;
    int bonusF;
    Map<String, Street> streetMap = new HashMap<>();
    List<Car> cars = new ArrayList<>();
    Map<Integer, Intersection> intersectionsMap = new HashMap<>();


    public DataContainer(List<String> lines) {
        parseFirstLine(lines.get(0).split(" "));
        initializeStreetsAndIntersections(lines.subList(1, streetsSCounts + 1));
        initializeCars(lines.subList(streetsSCounts + 1, lines.size()));
    }

    private void parseFirstLine(String[] s) {
        this.durationD = Integer.parseInt(s[0]);
        this.intersectionsI = Integer.parseInt(s[1]);
        this.streetsSCounts = Integer.parseInt(s[2]);
        this.carsV = Integer.parseInt(s[3]);
        this.bonusF = Integer.parseInt(s[4]);
    }

    private void initializeStreetsAndIntersections(List<String> lines) {
        for (String s : lines) {
            String[] s1 = s.split(" ");
            Street street = new Street(s1[2], Integer.parseInt(s1[3]), Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), 0);
            streetMap.put(street.getName(), street);
            Intersection i1 = intersectionsMap.get(street.getStartIntersection());
            Intersection i2 = intersectionsMap.get(street.getEndIntersection());
            if (i1 == null) {
                i1 = new Intersection(street.getStartIntersection());
                intersectionsMap.put(street.getStartIntersection(), i1);
            }
            if (i2 == null) {
                i2 = new Intersection(street.getEndIntersection());
                intersectionsMap.put(street.getEndIntersection(), i2);
            }
            i1.getOut().add(street);
            i2.getIn().add(street);
        }
    }

    private void initializeCars(List<String> lines) {
        lines.stream().map(s -> s.split(" ")).forEach(s1 -> {
            List<Street> streets = new ArrayList<>();
            IntStream.range(1, s1.length).mapToObj(i -> streetMap.get(s1[i])).forEach(street -> {
                street.setCounter(street.getCounter() + 1);
                streets.add(street);
            });
            cars.add(new Car(Integer.parseInt(s1[0]), streets));
        });
    }

}
