package com.kata.stack;


public class ZeroSizeStack implements Stack {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void push(int element) {
        throw new StackOverflowException();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int pop() {
        throw new StackUnderflowException();
    }

    @Override
    public int top() {
        throw new StackEmptyException();
    }

    @Override
    public Integer find(int i) {
        return null;
    }

}
