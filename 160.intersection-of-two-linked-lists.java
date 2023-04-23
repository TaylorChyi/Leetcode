/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        ListNode cursorA = headA;
        ListNode cursorB = headB;

        for (; tempHeadA != null; tempHeadA = tempHeadA.next, sizeA++) {
        }
        for (; tempHeadB != null; tempHeadB = tempHeadB.next, sizeB++) {
        }
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                cursorA = cursorA.next;
            }
        } else {
            for (int i = 0; i < sizeB - sizeA; i++) {
                cursorB = cursorB.next;
            }
        }

        while (cursorA != cursorB) {
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }

        return cursorA;

    }
}
// @lc code=end

