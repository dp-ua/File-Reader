package com.examples.filereader.console.jdbc;

import com.examples.filereader.console.file.InfoCollector;

import java.io.File;
import java.sql.*;
import java.util.Calendar;

public class JdbcService {
    Connection connection;

    public JdbcService(Connection connection) {
        this.connection = connection;
    }


    public int saveLineInfo(int fileID, InfoCollector lineInfo) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO line_info " +
                "(fileid, words_count, length, longest_word, shortest_word, average) " +
                "VALUES (?,?,?,?,?,?)";

        try (
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, fileID);
            statement.setInt(2, lineInfo.wordsCount);
            statement.setInt(3, lineInfo.length);
            statement.setString(4, lineInfo.getLongestWord());
            statement.setString(5, lineInfo.getShortestWord());
            statement.setDouble(6, lineInfo.averageWordLength);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Add Line info failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Add Line info failed, no ID obtained.");
                }
            }
        }
    }


    public int saveFileInfo(InfoCollector fileInfo, File file) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO file_info " +
                "(path, date, words_count, length, longest_word, shortest_word, average, lines_count) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try (
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, file.getAbsolutePath());
            statement.setLong(2, Calendar.getInstance().getTimeInMillis());
            statement.setInt(3, fileInfo.wordsCount);
            statement.setInt(4, fileInfo.length);
            statement.setString(5, fileInfo.getLongestWord());
            statement.setString(6, fileInfo.getShortestWord());
            statement.setDouble(7, fileInfo.averageWordLength);
            statement.setInt(8, fileInfo.linesCount);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Add File info failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Add File info failed, no ID obtained.");
                }
            }
        }

    }

}
