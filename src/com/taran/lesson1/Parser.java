package com.taran.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String sourceMathString;
    private List<String> apartElementsOfExpression;
    private List outputList;
    private Stack stackForSign;

    public Parser(String mathString) {
        this.sourceMathString = mathString;
        this.outputList = new ArrayList(mathString.length());
        this.stackForSign = new Stack(mathString.length());
        this.apartElementsOfExpression = new ArrayList<>();
    }

    public List splitExpression() {
        Pattern pattern = Pattern.compile("\\W|\\d+");
        Matcher matcher = pattern.matcher(sourceMathString);

        while (matcher.find()) {
            apartElementsOfExpression.add(matcher.group());
        }

        return apartElementsOfExpression;
    }

    public List<String> addSignsInEnd() {
        while (!stackForSign.isEmpty()) {
            outputList.add(stackForSign.pop());
        }
        return outputList;
    }

    public void evaluateMinusOrPlus(String currentElement) {
        if (stackForSign.readTop().equals("(")) {
            stackForSign.push(currentElement);
        } else {
            while (!stackForSign.isEmpty() && !stackForSign.readTop().equals("(")) {
                outputList.add(stackForSign.pop());
            }
            stackForSign.push(currentElement);
        }
    }

    public void ifFoundCloseBracket() {
        while (!stackForSign.readTop().equals("(")) {
            outputList.add(stackForSign.pop());
        }

        if (stackForSign.readTop().equals("(")) {
            stackForSign.pop();
        }
    }

    public List parseInPolishReverse() {

        splitExpression();

        Pattern patternNumber = Pattern.compile("\\d+");

        for (String currentElement: apartElementsOfExpression) {
            Matcher matcherNumber = patternNumber.matcher(currentElement);
            if (matcherNumber.find()) {
                outputList.add(matcherNumber.group());
                continue;
            }

            if (stackForSign.isEmpty()) {
                stackForSign.push(currentElement);
            } else {
                switch (currentElement) {
                    case ("+"):
                    case ("-"):
                        evaluateMinusOrPlus(currentElement);
                        break;

                    case ("*"):
                    case ("/"):
                        stackForSign.push(currentElement);
                        break;

                    case ("("):
                        stackForSign.push(currentElement);
                        break;

                    case (")"):
                        ifFoundCloseBracket();
                        break;
                    }
                }
            }

        addSignsInEnd();

        return outputList;
    }
}


