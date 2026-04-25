package org.example.parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Mission;
import org.example.parsers.handlers.*;

public class MissionParserChain {

    private static final List<MissionParser> PARSERS = new ArrayList<>();

    static {
        PARSERS.add(new TxtParserHandler());
        PARSERS.add(new JsonParserHandler());
        PARSERS.add((MissionParser) new XmlParserHandler());
        PARSERS.add(new YamlParserHandler());
        PARSERS.add(new NoExtensionParserHandler());
        // Новый парсер добавляется сюда одной строкой
    }

    public static MissionParser getChain() {
        if (PARSERS.isEmpty()) {
            return null;
        }

        // Построение цепочки Chain of Responsibility
        for (int i = 0; i < PARSERS.size() - 1; i++) {
            PARSERS.get(i).setNext(PARSERS.get(i + 1));
        }

        return PARSERS.get(0);
    }

    public static Mission parse(File file) throws MissionParseException {
        MissionParser chain = getChain();
        if (chain == null) {
            throw new MissionParseException("Нет ни одного парсера в цепочке");
        }
        return chain.parse(file);
    }
}
