package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ReadWordImpl implements ReadWord {

    private Connection connection = new ConnectionImpl();
    private static final Log log = LogFactory.getLog(ReadWordImpl.class);

    public XWPFWordExtractor getReadWord() {

        try {
            Properties prop = connection.getConnectWord();

            FileInputStream in = new FileInputStream(new File(prop.getProperty("word.input")));
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(in));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            return extractor;
        } catch (IOException e) {
            log.error(e);
        } catch (InvalidFormatException e) {
            log.error(e);
        }
        return null;
    }
}
