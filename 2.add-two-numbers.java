/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0, l1);
        int carry = 0;
        boolean unfinished = true;
        int val = 0;
        while ( unfinished || carry == 1) {

            if (unfinished) {
                val = l1.val;
                l1.val = (val + l2.val + carry) % 10;
                carry = (val + l2.val + carry) / 10;

                if (l1.next == null) {
                    l1.next = l2.next;
                    unfinished = false;
                }
                
                if (l2.next == null) {
                    unfinished = false;
                }
                
                if (unfinished) {
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            else {
                if (l1.next == null && carry == 1) {
                    l1.next = new ListNode(1, null);
                    carry = 0;
                }
                else {
                    if (carry == 1) {
                        l1 = l1.next;
                        val = l1.val;
                        l1.val = (val + carry) % 10;
                        carry = (val + carry) / 10;
                    }
                }
                
                
            }
            
        }
        return res.next;
    }
}
// @lc code=end

