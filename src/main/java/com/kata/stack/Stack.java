package com.kata.stack;

public interface Stack {

    boolean isEmpty();

    void push(int element);

    int getSize();

    int pop();

    int top();

    Integer find(int i);
}
