package com.examples.filereader.console.user;

import java.io.IOException;

public interface UI {
    void write(String output);
    String read() throws IOException;

}
