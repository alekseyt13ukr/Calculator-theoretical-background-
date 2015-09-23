package com.taran.lesson1;

import java.util.*;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser("1+2*(5-3)+(5*111) = ");
        EvaluatorFullExpression evaluatorFullExpression = new EvaluatorFullExpression(parser.parseInPolishReverse());
        System.out.println("1+2*(5-3)+(5*111) = " + evaluatorFullExpression.calculateExpression());

    }
}
