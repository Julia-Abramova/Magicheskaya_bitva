package org.example.parsers.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Mission;
import org.example.parsers.BaseMissionParser;
import org.example.parsers.MissionParseException;

import java.io.File;

public class XmlParserHandler extends BaseMissionParser {

    private static final XmlMapper mapper;

    static {
        mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    @Override
    public boolean canHandle(File file) {
        return file.getName().toLowerCase().endsWith(".xml");
    }

    @Override
    protected Mission doParse(File file) throws MissionParseException {
        try {
            return mapper.readValue(file, Mission.class);
        } catch (Exception e) {
            e.printStackTrace(); 
            throw new MissionParseException("Ошибка при разборе XML-файла: " + file.getName(), e);
        }
    }
}