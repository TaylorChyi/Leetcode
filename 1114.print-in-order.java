/*
 * @lc app=leetcode id=1114 lang=java
 *
 * [1114] Print in Order
 */

// @lc code=start
class Foo {
    int process = 1;
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (this.process != 1) {}
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.process++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (this.process != 2) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.process++;

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (this.process != 3) {}

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
// @lc code=end

