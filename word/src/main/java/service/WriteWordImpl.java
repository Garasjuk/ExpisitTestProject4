package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteWordImpl implements WriteWord {

    private Connection connection = new ConnectionImpl();
    private FileOutputStream out;
    private static final Log log = LogFactory.getLog(WriteWordImpl.class);

    public void getWriteWord(StringBuffer text) throws IOException {

        try {
            XWPFDocument document = new XWPFDocument();

            Properties prop = connection.getConnectWord();

            out = new FileOutputStream(new File(prop.getProperty("word.output")));

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(text.toString());
            document.write(out);

            System.out.println("Word written successfully");

        } catch (IOException e) {
            log.error(e);
        } finally {
            out.close();
        }
    }
}
