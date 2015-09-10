package com.taran.lesson1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluatorMStrTest {

    static EvaluatorMStr evaluatorMStr;
    static Parser parser;

    @BeforeClass
    public static void setUpClass() {
        parser = new Parser("2-1+(1*9)");
        parser.separateString();

    }

    @Before
    public void setUp() {
        evaluatorMStr = new EvaluatorMStr(parser.parseInPolishReverse());
    }

    @Test
    public void countMathStringTest() {
        assertEquals("10", evaluatorMStr.countString());
    }
}
