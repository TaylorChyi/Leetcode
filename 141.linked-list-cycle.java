/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tortiose = head;
        ListNode hare = head;
        while (hare!= null && hare.next!= null) {
            tortiose = tortiose.next;
            hare = hare.next.next;
            if (hare == tortiose) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

