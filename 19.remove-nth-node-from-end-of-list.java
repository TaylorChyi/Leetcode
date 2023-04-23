/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
@SuppressWarnings("all")
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cursor = new ListNode(0, head);
        ListNode prev = new ListNode(0, head);
        ListNode res = prev;

        while (cursor.next != null) {
            cursor = cursor.next;
            if (n > 0) {
                n--;
            }
            else {
                prev = prev.next;
            }
        }

        prev.next = prev.next.next;
        return res.next;
    }
}
// @lc code=end

