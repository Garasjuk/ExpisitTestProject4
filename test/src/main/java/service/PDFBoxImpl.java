package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class PDFBoxImpl implements PDFBox {

    @Autowired
    private Connection connection = new ConnectionImpl();
    private PDDocument doc1, doc2;
    private static final Log log = LogFactory.getLog(PDFBoxImpl.class);

    public void getPDFBox() throws IOException {

        try {
            Properties prop = connection.getConnectPDF();

            File file1 = new File(prop.getProperty("pdf.file1"));
            doc1 = PDDocument.load(file1);

            File file2 = new File(prop.getProperty("pdf.file2"));
            doc2 = PDDocument.load(file2);

            PDFMergerUtility PDFmerger = new PDFMergerUtility();

            PDFmerger.setDestinationFileName(prop.getProperty("pdf.outFile"));

            PDFmerger.addSource(file1);
            PDFmerger.addSource(file2);

            PDFmerger.mergeDocuments();

            System.out.println("Documents merged");

        } catch (IOException e) {
            log.error(e);
        }
        finally {
            doc1.close();
            doc2.close();
        }
    }
}
