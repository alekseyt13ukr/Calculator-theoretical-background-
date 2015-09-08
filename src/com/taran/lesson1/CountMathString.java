package com.taran.lesson1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountMathString {

    private List<String> listOfElements;

    public CountMathString(List listOfElements) {
        this.listOfElements = listOfElements;
    }

    public int countString() {
        for (String currentElement: listOfElements) {
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(currentElement);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        return 0;
    }
}
