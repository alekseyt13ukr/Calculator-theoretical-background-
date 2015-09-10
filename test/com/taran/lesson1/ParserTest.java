package com.taran.lesson1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    public void separateStringTest() {
        listOfElements.add("3");
        listOfElements.add("+");
        listOfElements.add("4");
        listOfElements.add("*");
        listOfElements.add("111");
        assertEquals(listOfElements, parser.separateString());
    }

    @Test
    public void parseTest() {
        listOfElements.add("3");
        listOfElements.add("4");
        listOfElements.add("111");
        listOfElements.add("*");
        listOfElements.add("+");
        parser.separateString();
        assertEquals(listOfElements, parser.parse());
    }
}
