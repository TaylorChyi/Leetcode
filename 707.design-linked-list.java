/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new Node(Integer.MAX_VALUE);
        tail = new Node(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node current;
        if (index > size / 2) {
            current = tail;
            while (size - index++ > 0) {
                current = current.prev;
            }
        }
        else {
            current = head;
            while (index-- >= 0) {
                current = current.next;
            }
        }

        return current.val;
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        size++;

        newHead.next = head.next;
        head.next = newHead;
        newHead.next.prev = newHead;
        newHead.prev = head;
    }
    
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        size++;

        newTail.prev = tail.prev;
        tail.prev = newTail;
        newTail.next = tail;
        newTail.prev.next = newTail;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        Node current;
        if (index > size / 2) {
            current = tail;
            while (size - index++ > 0) {
                current = current.prev;
            }
        }
        else {
            current = head;
            while (index-- >= 0) {
                current = current.next;
            }
        }

        Node addNode = new Node(val);
        addNode.prev = current.prev;
        current.prev.next = addNode;
        addNode.next = current;
        current.prev = addNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node current = head.next;
        while (index-- > 0) {
            current = current.next;
        }
        
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

