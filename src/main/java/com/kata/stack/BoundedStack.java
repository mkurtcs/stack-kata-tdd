package com.kata.stack;

public class BoundedStack implements Stack {

    private boolean empty = true;
    private int size;
    private int capacity;
    private int elements[];

    protected BoundedStack(int capacity) {
        if(capacity < 0)
            throw new IllegalCapacityException();
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public static Stack make(int capacity) {
        if(capacity == 0)
            return new ZeroSizeStack();
        return new BoundedStack(capacity);
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

    @Override
    public void push(int element) {
        if(size == capacity)
            throw new StackOverflowException();
        this.elements[size++] = element;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int pop() {
        if(empty())
            throw new StackUnderflowException();
        return this.elements[--size];
    }

    private boolean empty() {
        return size == 0;
    }

    @Override
    public int top() {
        if(empty())
            throw new StackEmptyException();
        return elements[size -1];
    }

    @Override
    public Integer find(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if(elements[i] == element)
                return (size - 1) - i;
        }
        return null;
    }

}
