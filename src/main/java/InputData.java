import java.util.List;

public class InputData {
    private final long durationD;
    private final long intersectionsI;
    private final long streetsS;
    private final long carsV;
    private final int bonusF;

    public InputData(List<String> lines) {
        String[] s = lines.get(0).split(" ");
        this.durationD = Long.parseLong(s[0]);
        this.intersectionsI = Long.parseLong(s[1]);
        this.streetsS = Long.parseLong(s[2]);
        this.carsV = Long.parseLong(s[3]);
        this.bonusF = Integer.parseInt(s[4]);
    }

    @Override
    public String toString() {
        return "InputData{" +
                "durationD=" + durationD +
                ", intersectionsI=" + intersectionsI +
                ", streetsS=" + streetsS +
                ", carsV=" + carsV +
                ", bonusF=" + bonusF +
                '}';
    }
}
