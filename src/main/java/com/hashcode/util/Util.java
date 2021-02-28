package com.hashcode.util;

import lombok.SneakyThrows;

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

    @SneakyThrows
    public static void writingToFile(List<String> lines, String name) {
        PrintWriter pw = new PrintWriter("src/main/resources/output/output_" + name + ".txt");
        lines.forEach(pw::println);
        pw.close();
    }

    @SneakyThrows
    public static List<String> readLines(String input) {
        return Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8);
    }


}
