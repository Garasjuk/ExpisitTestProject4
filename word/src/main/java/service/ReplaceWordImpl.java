package service;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.IOException;
import java.util.Properties;

public class ReplaceWordImpl implements ReplaceWord {

    private Connection connection = new ConnectionImpl();

    public StringBuffer getReplaceWord(XWPFWordExtractor extractor) {

        try {
            Properties prop = connection.getConnectWord();
            StringBuffer textOut = new StringBuffer(extractor.getText().replaceAll(prop.getProperty("word.initial"), prop.getProperty("word.final")));
            return textOut;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
