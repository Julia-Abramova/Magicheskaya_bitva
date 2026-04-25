package org.example.parsers;

import java.io.File;
import org.example.model.Mission;

public interface MissionParser {
    Mission parse(File file) throws MissionParseException;
    boolean canHandle(File file);
    void setNext(MissionParser next);
}