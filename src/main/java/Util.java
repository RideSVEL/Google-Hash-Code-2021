import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class Util {

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static void writingToFile(List<?> lines, String name) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("output\\" + name + ".out");
        pw.println(lines.size());
//        pw.print("temp");
        pw.close();
    }

    public static List<String> readLines(String input) throws IOException {
        return Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);
    }


}
