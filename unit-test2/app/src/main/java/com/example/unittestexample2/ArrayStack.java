package com.example.unittestexample2;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {

    private List<E> list = new ArrayList<E>();

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
