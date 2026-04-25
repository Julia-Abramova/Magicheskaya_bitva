package org.example.parsers.handlers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

import org.example.model.Mission;
import org.example.parsers.BaseMissionParser;
import org.example.parsers.MissionParseException;

public class XmlParserHandler extends BaseMissionParser {

    private static final XmlMapper mapper = new XmlMapper();

    public XmlParserHandler() {    }

    @Override
    public boolean canHandle(File file) {
        return file.getName().toLowerCase().endsWith(".xml");
    }

    @Override
    protected Mission doParse(File file) throws MissionParseException {
        try {
            return mapper.readValue(file, Mission.class);
        } catch (Exception e) {
            throw new MissionParseException("Ошибка при разборе XML-файла: " + file.getName(), e);
        }
    }
}