package com.hashcode.logic;

import com.hashcode.container.DataContainer;
import com.hashcode.util.Util;

import java.util.Arrays;

public class Solver {

    String[] files = {"a", "b", "c", "d", "e", "f"};

    private void solve(String name) {
        System.out.println("Work with file: " + name);
        Util.writingToFile(
                new Logic(
                        new DataContainer(
                                Util.readLines("src/main/resources/input/" + name + ".txt"))).solve(), name);
    }

    public void work() {
        Arrays.stream(files).forEach(this::solve);
    }
}
