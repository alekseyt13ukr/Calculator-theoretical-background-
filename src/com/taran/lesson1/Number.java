package com.taran.lesson1;

public class Number {

    private String numberStr;

    public Number(String numberStr) {
        this.numberStr = numberStr;
    }

    public int parseInt() {
        int numberInt = Integer.parseInt(numberStr);
        return numberInt;
    }
}
