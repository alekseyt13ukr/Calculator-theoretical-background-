package com.taran.lesson1;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StackTest {

    private Stack stack;
    private List<String> list;

    @Before
    public void setUp() {
        list = new ArrayList(Arrays.asList("test1", "test2", "test3"));
        stack = new Stack(list.size());
    }

    @Test
    public void pushTest() {
        int sizeBeforePush = stack.getTop();
        stack.push(list.get(0));
        int sizeAfterPush = stack.getTop();
        assertEquals(sizeBeforePush + 1, sizeAfterPush);
    }

    @Test
    public void popTest() {
        stack.push(list.get(0));
        stack.push(list.get(1));
        int sizeBeforePop = stack.getTop();
        String actualString = stack.pop();
        int sizeAfterPop = stack.getTop();
        assertEquals(list.get(1), actualString);
        assertEquals(sizeBeforePop - 1, sizeAfterPop);
    }

    @Test
    public void isEmptyTest() {
        assertTrue(stack.isEmpty());
        stack.push(list.get(0));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void readTopTest() {
        stack.push(list.get(0));
        String actual = stack.readTop();
        assertEquals("test1", actual);
    }
}
