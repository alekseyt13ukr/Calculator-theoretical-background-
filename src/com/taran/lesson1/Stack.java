package com.taran.lesson1;

public class Stack {

    private int size;
    private int top;
    String[] stack;

    public Stack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    public void push(String currentElement) {
        stack[++top] = currentElement;
    }

    public String pop() {
        return stack[top--];
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

    public void setTop(int top) {
        this.top = top;
    }
}
