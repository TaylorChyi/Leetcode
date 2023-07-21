/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    Boolean isPush = false;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        isPush = true;
        putBack();
        inStack.push(x);
    }
    
    public int pop() {
        if (isPush) {
            isPush = false;
            putOut();
        }        

        return outStack.pop();
    }
    
    public int peek() {
        if (isPush) {
            isPush = false;
            putOut();
        }

        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void putOut() {
        while (inStack.size() > 0) {
            outStack.push(inStack.pop());
        }
    }

    public void putBack() {
        while (outStack.size() > 0) {
            inStack.push(outStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

