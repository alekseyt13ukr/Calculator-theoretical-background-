package com.taran.lesson1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountMathStringTest {

    static CountMathString countMathString;
    static Parser parser;

    @BeforeClass
    public static void setUpClass() {
        parser = new Parser("2-1+(1*9)");
        parser.separateString();

    }

    @Before
    public void setUp() {
        countMathString = new CountMathString(parser.parse());
    }

    @Test
    public void countMathStringTest() {
        assertEquals("10", countMathString.countString());
    }
}
