package com.example.unittestexample2;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<E> implements Queue<E> {

    private List<E> list = new ArrayList<E>();

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
