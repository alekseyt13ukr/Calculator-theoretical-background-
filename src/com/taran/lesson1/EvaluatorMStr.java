package com.taran.lesson1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluatorMStr {

    private List<String> listOfElements;
    private Stack stack;

    public EvaluatorMStr(List listOfElements) {
        this.listOfElements = listOfElements;
        this.stack = new Stack(listOfElements.size());
    }

    public String countString() {
        Pattern patternSign = Pattern.compile("\\W");
        Pattern patternNumber = Pattern.compile("\\d+");

        for (int i = 0; i < listOfElements.size(); i++) {

            Matcher matcherNumber = patternNumber.matcher(listOfElements.get(i));
            while (matcherNumber.find()) {
                stack.push(matcherNumber.group());
            }

            Matcher matcherSign = patternSign.matcher(listOfElements.get(i));
            CalculatePrimitiveExpr calculatePrimitiveExpr;
            while (matcherSign.find()) {
                switch (matcherSign.group()) {
                    case ("+") :
                        calculatePrimitiveExpr = new CalculatePrimitiveExpr("+",
                                new Number(stack.pop()), new Number(stack.pop()));
                        stack.push(calculatePrimitiveExpr.calculatePrimitiveExpr());
                        break;
                    case ("-") :
                        calculatePrimitiveExpr = new CalculatePrimitiveExpr("-",
                                new Number(stack.pop()), new Number(stack.pop()));
                        stack.push(calculatePrimitiveExpr.calculatePrimitiveExpr());
                        break;
                    case ("*") :
                        calculatePrimitiveExpr = new CalculatePrimitiveExpr("*",
                                new Number(stack.pop()), new Number(stack.pop()));
                        stack.push(calculatePrimitiveExpr.calculatePrimitiveExpr());
                        break;
                }
            }
        }

        return stack.pop();
    }
}
