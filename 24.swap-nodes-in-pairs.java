/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0, head);

        ListNode cursor = head;
        ListNode prev = result;

        ListNode first;
        ListNode second;

        while (cursor != null) {
            first = cursor;
            second = cursor = cursor.next;

            if (first!= null && second!= null) {
                cursor= cursor.next;

                second.next = first;
                prev.next = second;
                first.next = cursor;
                prev = first;
            }
        }
        return result.next;
    }
}
// @lc code=end

