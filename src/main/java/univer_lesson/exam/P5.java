package univer_lesson.exam;

import java.util.EmptyStackException;

public class P5 {
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        boolean allTestsPassed = true;

        try {
            stack.push(10);
            if (stack.top() != 10) {
                System.out.println("Test failed: Top element is not 10 after push.");
                allTestsPassed = false;
            }
            stack.push(20);
            if (stack.size() != 2) {
                System.out.println("Test failed: Stack size is not 2 after two pushes.");
                allTestsPassed = false;
            }

            if (stack.pop() != 20) {
                System.out.println("Test failed: Popped element is not 20.");
                allTestsPassed = false;
            }
            if (stack.size() != 1) {
                System.out.println("Test failed: Stack size is not 1 after one pop.");
                allTestsPassed = false;
            }

            stack.pop();
            try {
                stack.pop();
                System.out.println("Test failed: No exception thrown on stack underflow.");
                allTestsPassed = false;
            } catch (EmptyStackException e) {
                System.out.println("Underflow handled: " + e.getMessage());
            }

            stack.push(30);
            stack.push(40);
            stack.push(50);
            try {
                stack.push(60);
                System.out.println("Test failed: No exception thrown on stack overflow.");
                allTestsPassed = false;
            } catch (StackOverflowError e) {
                System.out.println("Overflow handled: " + e.getMessage());
            }

            if (stack.isEmpty()) {
                System.out.println("Test failed: Stack should not be empty.");
                allTestsPassed = false;
            }

            stack.pop();
            stack.pop();
            stack.pop();
            if (!stack.isEmpty()) {
                System.out.println("Test failed: Stack should be empty after popping all elements.");
                allTestsPassed = false;
            }

        } catch (Exception e) {
            allTestsPassed = false;
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        if (allTestsPassed)
            System.out.println("All tests passed successfully.");
        else
            System.out.println("Some tests failed.");
    }
}

class Stack {
    private final int[] stack;
    private int top;
    private final int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (top == capacity - 1)
            throw new StackOverflowError("Stack overflow: Cannot push, stack is full.");
        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top--];
    }

    public int top() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}