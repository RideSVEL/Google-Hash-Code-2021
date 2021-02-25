import lombok.Data;

import java.util.List;

@Data
public class InputData {

    private int durationD;
    private int intersectionsI;
    private int streetsS;
    private int carsV;
    private int bonusF;
    private List<String> streetsLines;
    private List<String> waysLines;

    public InputData(List<String> lines) {
        parseFirstLine(lines.get(0).split(" "));
        this.streetsLines = lines.subList(1, streetsS - 1);
        this.waysLines = lines.subList(carsV, lines.size() - 1);
    }

    private void parseFirstLine(String[] s) {
        this.durationD = Integer.parseInt(s[0]);
        this.intersectionsI = Integer.parseInt(s[1]);
        this.streetsS = Integer.parseInt(s[2]);
        this.carsV = Integer.parseInt(s[3]);
        this.bonusF = Integer.parseInt(s[4]);
    }

}
