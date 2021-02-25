import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> strings = Util.readLines("src/main/resources/input/a.txt");
        InputData inputData = new InputData(strings);
        System.out.println(inputData);
    }
}
