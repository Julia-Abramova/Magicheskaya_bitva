package org.example;

import org.example.model.Mission;
import org.example.parsers.MissionParseException;
import org.example.parsers.MissionParserChain;
import org.example.printer.MissionPrinter;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу миссии: ");
        String path = scanner.nextLine().trim();

        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("Файл не найден: " + path);
            return;
        }

        try {
            Mission mission = MissionParserChain.parse(file);
            MissionPrinter.print(mission);
        } catch (MissionParseException e) {
            System.out.println("Ошибка разбора файла: " + e.getMessage());
        }
    }
    /*
    C:\Users\marin\Documents\GitHub\Magicheskaya_bitva\Mag_bitva\src\main\resources\Mission A1.json
    C:\Users\marin\Documents\GitHub\Magicheskaya_bitva\Mag_bitva\src\main\resources\Mission A2.yaml
    C:\Users\marin\Documents\GitHub\Magicheskaya_bitva\Mag_bitva\src\main\resources\Mission A3.xml
    C:\Users\marin\Documents\GitHub\Magicheskaya_bitva\Mag_bitva\src\main\resources\Mission A4.txt
    C:\Users\marin\Documents\GitHub\Magicheskaya_bitva\Mag_bitva\src\main\resources\Mission A5
    */
}