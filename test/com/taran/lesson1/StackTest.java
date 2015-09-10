package com.taran.lesson1;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(10);
    }

    @Test
    public void pushTest() {
        int sizeBeforePush = stack.getTop();
        stack.push("test");
        int sizeAfterPush = stack.getTop();
        assertEquals(sizeBeforePush + 1, sizeAfterPush);
    }

    @Test
    public void popTest() {
        stack.push("test1");
        stack.push("test2");
        int sizeBeforePop = stack.getTop();
        String actualString = stack.pop();
        int sizeAfterPop = stack.getTop();
        assertEquals("test2", actualString);
        assertEquals(sizeBeforePop - 1, sizeAfterPop);
    }

    @Test
    public void isEmptyTest() {
        stack.setTop(-1);
        assertTrue(stack.isEmpty());
        stack.setTop(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void readTopTest() {
        stack.push("test");
        String actual = stack.readTop();
        assertEquals("test", actual);
    }
}
