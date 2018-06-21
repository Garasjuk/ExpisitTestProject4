import Controller.Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class WordApplication {

    private static Controller controller = new Controller();
    private static final Log log = LogFactory.getLog(WordApplication.class);

    public static void main(String[] args) {

        try {
            controller.getReplace();
        } catch (IOException e) {
            log.error(e);
        }

    }
}
