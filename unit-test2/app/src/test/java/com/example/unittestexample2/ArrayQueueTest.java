package com.example.unittestexample2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

    @Test
    void emptyOnCreate() {
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void nonEmptyAfterPush() {
        arrayQueue.push(1);
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    void pushPop3() {
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);

        assertEquals( 1, arrayQueue.pop());
        assertEquals(2, arrayQueue.pop());
        assertEquals(3, arrayQueue.pop());
        assertTrue(arrayQueue.isEmpty());
    }


    @Test
    void isEmpty() {
        assertTrue(arrayQueue.isEmpty());
    }
}