/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * 
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

