package com.hashcode.logic;

import org.apache.commons.lang3.time.StopWatch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        new Solver().work();
        System.out.println(stopWatch.getTime());
    }
}
