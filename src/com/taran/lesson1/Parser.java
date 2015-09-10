package com.taran.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String sourceMathString;
    private List<String> mStringElementsApart;
    private List outputList;
    private Stack stackForSign;

    public Parser(String mathString) {
        this.sourceMathString = mathString;
        this.outputList = new ArrayList(mathString.length());
        this.stackForSign = new Stack(mathString.length());
        this.mStringElementsApart = new ArrayList<>();
    }

    public List separateString() {
        Pattern pattern = Pattern.compile("\\W|\\d+");
        Matcher matcher = pattern.matcher(sourceMathString);

        while (matcher.find()) {
            mStringElementsApart.add(matcher.group());
        }

        return mStringElementsApart;
    }

    public List parseInPolishReverse() {
        Pattern patternNumber = Pattern.compile("\\d+");

        for (String currentElement: mStringElementsApart) {
            Matcher matcherNumber = patternNumber.matcher(currentElement);
            if (matcherNumber.find()) {
                outputList.add(matcherNumber.group());
            } else {
                if (stackForSign.isEmpty()) {
                    stackForSign.push(currentElement);
                } else {
                    switch (currentElement) {
                        case ("+"):
                        case ("-"):
                            if (stackForSign.readTop().equals("(")) {
                                stackForSign.push(currentElement);
                            } else {
                                while (!stackForSign.isEmpty() && !stackForSign.readTop().equals("(")) {
                                    outputList.add(stackForSign.pop());
                                }
                                stackForSign.push(currentElement);
                            }
                            break;
                        case ("*"):
                        case ("/"):
                            stackForSign.push(currentElement);
                            break;
                        case ("("):
                            stackForSign.push(currentElement);
                            break;
                        case (")"):

                            while (!stackForSign.readTop().equals("(")) {
                                outputList.add(stackForSign.pop());
                            }

                            if (stackForSign.readTop().equals("(")) {
                                stackForSign.pop();
                            }
                            break;
                    }
                }
            }
        }

        while (!stackForSign.isEmpty()) {
            outputList.add(stackForSign.pop());
        }

        return outputList;
    }
}


