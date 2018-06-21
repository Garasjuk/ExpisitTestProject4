package Controller;

import service.*;

import java.io.IOException;

public class Controller {

    private static ReadWord readWord = new ReadWordImpl();
    private static ReplaceWord replaceWord = new ReplaceWordImpl();
    private static WriteWord writeWord = new WriteWordImpl();

    public void getReplace() throws IOException {

        writeWord.getWriteWord(replaceWord.getReplaceWord(readWord.getReadWord()));
    }
}
