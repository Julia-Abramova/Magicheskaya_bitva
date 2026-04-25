package org.example.printer;

import org.example.model.Mission;

public class MissionPrinter {

    private static MissionPrintStrategy strategy = new ConsoleMissionPrinter();

    public static void setStrategy(MissionPrintStrategy newStrategy) {
        strategy = newStrategy;
    }

    public static void print(Mission mission) {
        strategy.print(mission);
    }
}