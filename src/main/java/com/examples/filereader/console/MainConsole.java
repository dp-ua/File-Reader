package com.examples.filereader.console;

import com.examples.filereader.console.file.Analyzer;
import com.examples.filereader.console.jdbc.JdbcService;
import com.examples.filereader.console.properties.MyProperties;
import com.examples.filereader.console.user.Console;
import com.examples.filereader.console.user.UI;
import com.examples.filereader.console.file.InfoCollector;
import com.examples.filereader.console.jdbc.JdbcConnection;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainConsole {

    public static void main(String[] args) {
        try {
            UI console = new Console();
            Analyzer analyzer = new Analyzer();
            MyProperties properties = new MyProperties();
            JdbcConnection jdbc = new JdbcConnection(
                    properties.getString("JDBC_DRIVER"),
                    properties.getString("DATABASE_URL"),
                    properties.getString("DB_USER"),
                    properties.getString("DB_PASS"));
            JdbcService jdbcService = new JdbcService(jdbc.getConnection());


            while (true) {
                console.write("Input file name:");
                try {


                    String inputLine = console.read();
                    if ("exit".equals(inputLine.toLowerCase().trim())) {
                        console.write("You choose Exit. Bye.");
                        break;
                    }


                    File file = new File(inputLine);
                    console.write("Calculate and save statistic for: "+ file.getAbsolutePath());

                    if (!file.isFile()) {
                        console.write("Input Error. File not find. Data to jdbc not saved");
                        continue;
                    }

                    List<InfoCollector> list = analyzer.analyzeFile(file);
                    InfoCollector fileInfo = analyzer.analyzeList(list);

                    int id = jdbcService.saveFileInfo(fileInfo, file);
                    int count = 0;
                    if (id > 0) {
                        for (InfoCollector i : list) {
                            jdbcService.saveLineInfo(id, i);
                            count++;
                        }
                    }
                    console.write("Info about " + inputLine + " inserted in table with id: " + id + ".\n" +
                            " Lines count info inserted in table: " + count);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
