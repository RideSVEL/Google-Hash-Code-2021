package com.hashcode.logic;

import com.hashcode.container.DataContainer;
import com.hashcode.models.Intersection;
import com.hashcode.models.Street;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Logic {

    List<Intersection> intersections;
    List<String> outputLines;

    public Logic(DataContainer dataContainer) {
        intersections = new ArrayList<>(dataContainer.getIntersectionsMap().values());
        outputLines = new ArrayList<>();
    }

    public List<String> solve() {
        long cntIntersections = 0;
        List<String> tmpLines = new ArrayList<>();
        for (Intersection intersection : intersections) {
            List<String> tmpLight = new ArrayList<>();
            int mite = (intersection.getIn().stream().mapToInt(Street::getCounter).sum() / intersection.getIn().size()) + 1;
            intersection.getIn().stream().filter(street -> street.getCounter() > 0).forEach(street -> {
                int counter = ((street.getCounter() / mite) == 0) ? 1 : street.getCounter() / mite;
                tmpLight.add(street.getName() + " " + counter);
            });
            if (tmpLight.size() > 0) {
                cntIntersections++;
                tmpLines.add(intersection.getId() + "");
                tmpLines.add(tmpLight.size() + "");
                tmpLines.addAll(tmpLight);
            }
        }
        outputLines.add(cntIntersections + "");
        outputLines.addAll(tmpLines);
        return outputLines;
    }
}
