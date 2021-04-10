package com.kata.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoundedStackTest {

    private Stack stack = StackFactory.make(2);

    @Test
    public void new_stack_is_empty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void after_one_push_stack_size_should_be_one() {
        push(1);
        assertEquals(1, stack.getSize());
    }

    @Test
    public void after_one_push_and_one_pop_stack_size_should_be_zero() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void when_pushed_past_limit_stack_overflows() {
        Stack stack = StackFactory.make(1);
        assertThrows(StackOverflowException.class, () -> {
            stack.push(5);
            stack.push(7);
        });
    }

    @Test
    public void when_empty_stack_popped_stack_underflows() {
        assertThrows(StackUnderflowException.class, stack::pop);
    }

    @Test
    public void when_one_is_pushed_one_is_popped() {
        Stack stack = StackFactory.make(1);
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    public void when_one_and_two_are_pushed_two_and_one_are_popped() {
        push(1);
        push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void when_creating_stack_with_negative_size_stack_should_throw_illegal_capacity() {
        assertThrows(IllegalCapacityException.class, () -> {
            Stack stack = BoundedStack.make(-1);
        });
    }

    @Test
    public void when_stack_created_with_zero_capacity_any_push_should_overlow() {
        assertThrows(StackOverflowException.class, () -> {
            StackFactory.make(0).push(1);
        });
    }

    @Test
    public void when_one_is_pushed_one_is_on_top() {
        push(1);
        assertEquals(1, stack.top());
    }

    @Test
    public void when_stack_is_empty_top_throws_empty() {
        assertThrows(StackEmptyException.class, stack::top);
    }

    @Test
    public void when_zero_capacity_stack_top_throws_empty() {
        assertThrows(StackEmptyException.class, () -> {
            StackFactory.make(0).top();
        });

    }

    @Test
    public void given_stack_with_one_and_two_pushed_find_one() {
        push(1);
        push(2);
        assertEquals(1, stack.find(1).intValue());
        assertEquals(0, stack.find(2).intValue());
    }

    @Test
    public void given_stack_with_no_two_find_two_should_return_null() {
        assertNull(stack.find(2));
    }

    private void push(int element) {
        stack.push(element);
    }
}
