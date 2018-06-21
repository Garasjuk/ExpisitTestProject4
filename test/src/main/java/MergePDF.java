import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.PDFBox;
import service.PDFBoxImpl;

import java.io.IOException;

public class MergePDF {

    @Autowired
    private static PDFBox pdfBox = new PDFBoxImpl();
    private static final Log log = LogFactory.getLog(MergePDF.class);

    public static void main(String[] args) {
        try {

            pdfBox.getPDFBox();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
