package service;

import java.io.IOException;
import java.util.Properties;

public interface Connection {
    Properties getConnectWord() throws IOException;
}
