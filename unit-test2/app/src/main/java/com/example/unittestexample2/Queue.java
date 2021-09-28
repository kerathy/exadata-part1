package com.example.unittestexample2;

public interface Queue<E> {

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();
}
