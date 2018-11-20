package com.examples.filereader.console.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class Analyzer {

    public InfoCollector analyzeString(String input) {
        if (input.trim().length() == 0) return new InfoCollector();

        String[] array = input.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : array) if (s.length() > 0) list.add(s);
        list.sort((first, second) -> Integer.compare(first.length(), second.length()));
        int sum = 0;
        for (String s : array) sum += s.length();
        return new InfoCollector(list.size(), input.length(), list.get(list.size() - 1), list.get(0), (double) sum / list.size(),1);
    }

    public InfoCollector analyzeList(List<InfoCollector> list) {
        ArrayList<String> words = new ArrayList<>();
        InfoCollector result = new InfoCollector(0, 0, null, null, 0,0);
        for (InfoCollector c : list) {
            result.linesCount++;
            if (!c.isBlank()) {
                result.averageWordLength = (result.wordsCount * result.averageWordLength + c.averageWordLength * c.wordsCount) /
                        (result.wordsCount + c.wordsCount);
                result.wordsCount += c.wordsCount;
                result.length += c.length;
                words.add(c.longestWord);
                words.add(c.shortestWord);

            }
        }
        words.sort((first, second) -> Integer.compare(first.length(), second.length()));
        result.longestWord = words.get(words.size() - 1);
        result.shortestWord = words.get(0);
        return result;
    }

    public List<InfoCollector> analyzeFile(File filename) throws IOException {
        List<InfoCollector> result = new ArrayList<>();
        Files.lines(filename.toPath(), StandardCharsets.UTF_8).forEach(input -> result.add(analyzeString(input)));
        return result;
    }

}
