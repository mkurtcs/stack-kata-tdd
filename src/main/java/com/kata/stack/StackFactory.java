package com.kata.stack;

public class StackFactory {

    public static Stack make(int capacity) {
        if(capacity == 0)
            return new ZeroSizeStack();
        return new BoundedStack(capacity);
    }
}
