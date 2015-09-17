package com.taran.lesson1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluatorFullExpressionTest {

    static EvaluatorFullExpression evaluatorFullExpression;
    static Parser parser;

    @BeforeClass
    public static void setUpClass() {
        parser = new Parser("2-1+(1*9)");
    }

    @Before
    public void setUp() {
        evaluatorFullExpression = new EvaluatorFullExpression(parser.parseInPolishReverse());
    }

    @Test
    public void countMathStringTest() {
        assertEquals("10", evaluatorFullExpression.calculateExpression());
    }
}
