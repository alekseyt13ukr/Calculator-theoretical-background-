package com.taran.lesson1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private List listOfElements;
    private Parser parser;

    @Before
    public void setUp() {
        listOfElements = new ArrayList<>();
        parser = new Parser("3+4*111");
    }

    @Test
    public void decompositionStringTest() {
        assertEquals(new ArrayList(Arrays.asList("3", "+", "4", "*", "111")), parser.splitExpression());
    }

    @Test
    public void parseTest() {
        parser.splitExpression();
        assertEquals(new ArrayList(Arrays.asList("3", "4", "111", "*", "+")), parser.parseInPolishReverse());
    }
}
