package com.examples.filereader.console.properties;

import java.util.ListResourceBundle;

public class MyProperties extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"JDBC_DRIVER", "com.mysql.jdbc.Driver"},
                {"DATABASE_URL", "jdbc:mysql://localhost/luxsoft"},
                {"DB_USER", "springuser"},
                {"DB_PASS", "ThePassword"},
        };
    }
}
