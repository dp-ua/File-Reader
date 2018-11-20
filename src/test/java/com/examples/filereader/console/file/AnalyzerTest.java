package com.examples.filereader.console.file;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalyzerTest {
    Analyzer analyzer;

    @Before
    public void setUp() {
        analyzer=new Analyzer();
    }

    @Test
    public void analyzeString() {
        String test = "hhhhhh mmmm jj";
        InfoCollector expected = new InfoCollector(3,14,"hhhhhh","jj",(double)4,1 );
        assertEquals(expected.toString(),analyzer.analyzeString(test).toString());
    }

    @Test
    public void analyzeList() {
        List<InfoCollector> testList = new ArrayList<>();
        testList.add(new InfoCollector(3,14,"hello","hi",(double)4,1 )) ;
        testList.add(new InfoCollector(4,20,"world","see",3,1 )) ;
        InfoCollector expected = new InfoCollector(7,34,"world","hi",(double)24/7,2 ) ;
        assertEquals(expected.toString(),analyzer.analyzeList(testList).toString());
    }
}