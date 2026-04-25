package org.example.parsers.handlers;

import org.example.model.*;
import org.example.parsers.MissionParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import org.example.parsers.BaseMissionParser;

public class JsonParserHandler extends BaseMissionParser {

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public boolean canHandle(File file) {
        return file.getName().toLowerCase().endsWith(".json");
    }

    @Override
    protected Mission doParse(File file) throws MissionParseException {
        try {
            return mapper.readValue(file, Mission.class);
        } catch (Exception e) {
            throw new MissionParseException("Ошибка при разборе JSON-файла: " + file.getName(), e);
        }
    }
}