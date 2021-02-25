import com.hashcode.models.Car;
import com.hashcode.models.Street;
import lombok.Data;

import java.util.*;

@Data
public class InputData {

    private int durationD;
    private int intersectionsI;
    private int streetsSCounts;
    private int carsV;
    private int bonusF;
    private List<String> waysLines;
    private Map<String, Street> streetMap = new HashMap<>();
    private List<Car> cars = new ArrayList<>();


    public InputData(List<String> lines) {
        parseFirstLine(lines.get(0).split(" "));
        initializeStreets(lines.subList(1, streetsSCounts + 1));
        initializeCars(lines.subList(streetsSCounts + 1, lines.size()));
    }

    private void parseFirstLine(String[] s) {
        this.durationD = Integer.parseInt(s[0]);
        this.intersectionsI = Integer.parseInt(s[1]);
        this.streetsSCounts = Integer.parseInt(s[2]);
        this.carsV = Integer.parseInt(s[3]);
        this.bonusF = Integer.parseInt(s[4]);
    }

    private void initializeStreets(List<String> lines) {
        for (String s : lines) {
            String[] s1 = s.split(" ");
            Street street = new Street(s1[2], Integer.parseInt(s1[3]), Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
            streetMap.put(street.getName(), street);
        }
    }

    private void initializeCars(List<String> lines) {
        for (String s : lines) {
            String[] s1 = s.split(" ");
            List<Street> streets = new ArrayList<>();
            for (int i = 1; i < s1.length; i++) {
                streets.add(streetMap.get(s1[i]));
            }
            cars.add(new Car(Integer.parseInt(s1[0]), streets));
        }
    }

}
