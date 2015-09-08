package com.taran.lesson1;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser("1+2*(5-3)+(5*111)");
        System.out.println("This is parsed string on elements: " + parser.separateString());
        System.out.println("This is reverse polish notation: " + parser.parse());
        CountMathString countMathString = new CountMathString(parser.parse());
        System.out.println("1+2*(5-3)+(5*111) = " + countMathString.countString());
    }
}
