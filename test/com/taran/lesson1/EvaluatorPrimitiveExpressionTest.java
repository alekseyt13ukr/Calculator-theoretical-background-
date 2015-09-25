package com.taran.lesson1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluatorPrimitiveExpressionTest {

    @Test
    public void plus() {
        assertEquals("12", new EvaluatorPrimitiveExpression("+", new Number("10"), new Number("2")).evaluatePrimitiveExpression());
    }

    @Test
    public void minus() {
        assertEquals("8", new EvaluatorPrimitiveExpression("-", new Number("2"), new Number("10")).evaluatePrimitiveExpression());
    }

    @Test
    public void multiply() {
        assertEquals("20", new EvaluatorPrimitiveExpression("*", new Number("2"), new Number("10")).evaluatePrimitiveExpression());
    }

    @Test
    public void divide() {
        assertEquals("5", new EvaluatorPrimitiveExpression("/", new Number("2"), new Number("10")).evaluatePrimitiveExpression());
    }
}
