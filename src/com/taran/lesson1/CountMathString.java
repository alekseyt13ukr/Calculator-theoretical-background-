package com.taran.lesson1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountMathString {

    private List<String> listOfElements;

    public CountMathString(List listOfElements) {
        this.listOfElements = listOfElements;
    }

    public String countString() {
        Pattern pattern = Pattern.compile("\\W");

        for (int i = 0; i < listOfElements.size(); i++) {

            Matcher matcher = pattern.matcher(listOfElements.get(i));

            while (matcher.find()) {
                switch (matcher.group()) {
                    case ("+") :
                        int plus = Integer.parseInt(listOfElements.get(i - 2)) + Integer.parseInt(listOfElements.get(i - 1));
                        replace((i - 2), plus);
                        i = 0;
                        break;
                    case ("-") :
                        int minus = Integer.parseInt(listOfElements.get(i - 2)) - Integer.parseInt(listOfElements.get(i - 1));
                        replace((i - 2), minus);
                        i = 0;
                        break;
                    case ("*") :
                        int multiplace = Integer.parseInt(listOfElements.get(i - 2)) * Integer.parseInt(listOfElements.get(i - 1));
                        replace((i - 2), multiplace);
                        i = 0;
                        break;
                }
            }
        }

        String[] result = new String[listOfElements.size()];
        result = listOfElements.toArray(result);

        return result[0];
    }

    public void replace(int positionForReplace, int valuesForReplace) {

        for (int i = 0; i < 3; i++) {
            listOfElements.remove(positionForReplace);
        }
        String valuesForReplaceInString = String.valueOf(valuesForReplace);
        listOfElements.add(positionForReplace, valuesForReplaceInString);
    }

    public List<String> getListOfElements() {
        return listOfElements;
    }
}
