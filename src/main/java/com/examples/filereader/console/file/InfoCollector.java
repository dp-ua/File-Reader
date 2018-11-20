package com.examples.filereader.console.file;

public class InfoCollector {
    public int wordsCount;
    public int length;
    public String longestWord;
    public String shortestWord;
    public double averageWordLength;
    public int linesCount;
    private boolean blank = false;

    public InfoCollector() {
        blank = true;
    }

    public boolean isBlank() {
        return blank;
    }

    public InfoCollector(int wordsCount, int length, String longestWord, String shortestWord, double averageWordLength, int linesCount) {
        this.wordsCount = wordsCount;
        this.length = length;
        this.longestWord = longestWord;
        this.shortestWord = shortestWord;
        this.averageWordLength = averageWordLength;
        this.linesCount = linesCount;
    }

    @Override
    public String toString() {
        if (blank) return "Blank String";
        return "InfoCollector{" +
                "wordsCount=" + wordsCount +
                ", length=" + length +
                ", longestWord='" + longestWord + '\'' +
                ", shortestWord='" + shortestWord + '\'' +
                ", averageWordLength=" + averageWordLength +
                ", linesCount=" + linesCount +
                '}';
    }


    public String getLongestWord() {
        return isBlank() ? "" : longestWord;
    }

    public String getShortestWord() {
        return isBlank() ? "" : shortestWord;
    }


}
