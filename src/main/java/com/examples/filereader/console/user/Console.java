package com.examples.filereader.console.user;

import java.io.*;


public class Console implements UI {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void write(String output) {
        System.out.println(output);
    }

    @Override
    public String read() throws IOException {
        String readln = reader.readLine();
        return readln;
    }
}
