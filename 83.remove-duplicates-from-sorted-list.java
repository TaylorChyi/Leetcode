/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        // if (head == null) {
        //     return head;
        // }

        // ListNode current = head;

        // ListNode cursor = head.next;
        // current.next = null;
        // ListNode result = current;

        // while (cursor != null) {
        //     if (current.val != cursor.val) {
        //         current.next = cursor;
        //         current = current.next;
        //     }
            
        //     cursor = cursor.next;
        // }
        
        // current.next = null;

        // return result;


        ListNode list = head;
         
        while(list != null && list.next != null) {
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        
        return head;
    }
}
// @lc code=end

