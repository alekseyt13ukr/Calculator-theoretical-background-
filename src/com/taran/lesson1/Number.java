package com.taran.lesson1;

public class Number {

    private int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }
}
