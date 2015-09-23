package com.taran.lesson1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluatorFullExpression {

    private List<String> expressionPrefixView;
    private Stack<String> stack;

    private static final Pattern PATTERN_SIGN = Pattern.compile("\\W");
    private static final Pattern PATTERN_NUMBER = Pattern.compile("\\d+");

    public EvaluatorFullExpression(List expressionPrefixView) {
        this.expressionPrefixView = expressionPrefixView;
        this.stack = new Stack<String>(expressionPrefixView.size());
    }

    public String calculateExpression() {

        for (String symbolOfExpression: expressionPrefixView) {

            Matcher matcherNumber = PATTERN_NUMBER.matcher(symbolOfExpression);
            while (matcherNumber.find()) {
                stack.push(matcherNumber.group());
            }

            Matcher matcherSign = PATTERN_SIGN.matcher(symbolOfExpression);
            EvaluatorPrimitiveExpression evaluatorPrimitiveExpression;
            while (matcherSign.find()) {
                switch (matcherSign.group()) {
                    case ("+") :
                        evaluatorPrimitiveExpression = new EvaluatorPrimitiveExpression("+",
                                new Number(stack.pop()), new Number(stack.pop()));
                        stack.push(evaluatorPrimitiveExpression.evaluatePrimitiveExpression());
                        break;
                    case ("-") :
                        evaluatorPrimitiveExpression = new EvaluatorPrimitiveExpression("-",
                                new Number(stack.pop()), new Number(stack.pop()));
                        stack.push(evaluatorPrimitiveExpression.evaluatePrimitiveExpression());
                        break;
                    case ("*") :
                        evaluatorPrimitiveExpression = new EvaluatorPrimitiveExpression("*",
                                new Number(stack.pop()), new Number(stack.pop()));
                        stack.push(evaluatorPrimitiveExpression.evaluatePrimitiveExpression());
                        break;
                }
            }
        }

        return stack.pop();
    }
}
