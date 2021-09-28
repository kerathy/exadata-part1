package com.example.unittestexample2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

    @Test
    void emptyOnCreate() {
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    void nonEmptyAfterPush() {
        arrayStack.push(1);
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    void pushPop3() {
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        assertEquals(3, arrayStack.pop());
        assertEquals(2, arrayStack.pop());
        assertEquals(1, arrayStack.pop());
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    void isEmpty() {
        assertTrue(arrayStack.isEmpty());
    }

}