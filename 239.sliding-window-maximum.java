/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    class myQueue {
        Deque<Integer> deque = new LinkedList<Integer>();;

        public void add(Integer pushNum) {
            push(pushNum);
        }

        public void add(Integer pushNum, Integer removeNum) {
            remove(removeNum);
            push(pushNum);
        }

        private void push(int num) {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.removeLast();
            }
            deque.offer(num);
        }

        private void remove(int num) {
            if (deque.peekFirst() == num) { 
                deque.poll();
            }
        }

        public int getMax() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        myQueue queue = new myQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                queue.add(nums[i], nums[i - k]);
            } else {
                queue.add(nums[i]);
            }
            if (i >= k - 1) {
                result[i - k + 1] = queue.getMax();
            }
        }
        return result;
    }
}
/* import java.util.Deque;
import java.util.LinkedList;

class Solution {
    class MonotonicQueue {
        Deque<Integer> deque = new LinkedList<Integer>();

        public void add(int num) {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.removeLast();
            }
            deque.offer(num);
        }

        public void remove(int num) {
            if (!deque.isEmpty() && deque.peekFirst() == num) {
                deque.poll();
            }
        }

        public int getMax() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MonotonicQueue queue = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                queue.remove(nums[i - k]);
            }
            queue.add(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = queue.getMax();
            }
        }
        return result;
    }
}
 */
// @lc code=end
