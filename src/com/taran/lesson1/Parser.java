package com.taran.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String mathString;
    private List<String> listOfElements = new ArrayList<>();
    Stack stack;

    public Parser(String mathString) {
        this.mathString = mathString;
        stack = new Stack(mathString.length());
    }

    public List separateString() {
        Pattern pattern = Pattern.compile("\\W|\\d+");
        Matcher matcher = pattern.matcher(mathString);

        while (matcher.find()) {
            listOfElements.add(matcher.group());
        }

        return listOfElements;
    }

    public List parse() {
        Pattern patternNumber = Pattern.compile("\\d+");
        List<String> outputPhrase = new ArrayList<>();

        for (String currentElement: listOfElements) {
            Matcher matcherNumber = patternNumber.matcher(currentElement);
            if (matcherNumber.find()) {
                outputPhrase.add(matcherNumber.group());
            } else {
                if (stack.isEmpty()) {
                    stack.push(currentElement);
                } else {
                    switch (currentElement) {
                        case ("+"):
                        case ("-"):
                            if (stack.readTop().equals("(")) {
                                stack.push(currentElement);
                            } else {
                                while (!stack.isEmpty() && !stack.readTop().equals("(")) {
                                    outputPhrase.add(stack.pop());
                                }
                                stack.push(currentElement);
                            }
                            break;
                        case ("*"):
                        case ("/"):
                            stack.push(currentElement);
                            break;
                        case ("("):
                            stack.push(currentElement);
                            break;
                        case (")"):

                            while (!stack.readTop().equals("(")) {
                                outputPhrase.add(stack.pop());
                            }

                            if (stack.readTop().equals("(")) {
                                stack.deleteElement();
                            }
                            break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            String pop = stack.pop();
            outputPhrase.add(pop);
        }
        return outputPhrase;
    }
}

