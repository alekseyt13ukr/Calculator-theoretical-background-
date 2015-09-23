package com.taran.lesson1;

public class Stack<E> {

    private int size;
    private static int top;
    private E[] stack;

    public Stack(int size) {
        this.size = size;
        this.stack = (E[]) new Object[size];
        this.top = -1;
    }

    public void push(E currentElement) {
        stack[++top] = currentElement;
    }

    public E pop() {
        E result = stack[top--];
        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public E readTop() {
        return stack[top];
    }

    public int getTop() {
        return top;
    }
}
