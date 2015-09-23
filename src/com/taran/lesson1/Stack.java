package com.taran.lesson1;

public class Stack<E> {

    private int size;
    private static int top;
    private String[] stack;

    public Stack(int size) {
        this.size = size;
        this.stack = new String[size];
        this.top = -1;
    }

    public void push(String currentElement) {
        stack[++top] = currentElement;
    }

    public String pop() {
        String result = stack[top--];
        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String readTop() {
        return stack[top];
    }

    public int getTop() {
        return top;
    }
}
