/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if (head == null) {
//             return null;
//         }

//         if (k <= 0) {
//             return head;
//         }

//         ListNode sub_first_node = head;
//         ListNode sub_last_node = head;

//         int len = 1;
//         while (sub_last_node.next != null) {
//             sub_last_node = sub_last_node.next;
//             len++;
//             if (len > k+1) {
//                 sub_first_node = sub_first_node.next;
//             }
//         }

//         if (k >= len) {
//             k = k % len;
//             if (k == 0) {
//                 return head;
//             }

//             for (int i = 0; i < len-k-1; i++) {
//                 sub_first_node = sub_first_node.next;
//             }
//         }

//         if (sub_first_node.next != null) {
//             ListNode tail = sub_first_node;
//             sub_first_node = sub_first_node.next;
//             tail.next = null;

//             sub_last_node.next = head;
//         }

//         return sub_first_node;
//     }
// }

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int len = getLength(head);

        // Reduce k to a small number if k is greater than or equal to len
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode subFirstNode = head;
        ListNode subLastNode = head;

        // Move subLastNode to its correct position
        for (int i = 0; i < k; i++) {
            if (subLastNode.next != null) {
                subLastNode = subLastNode.next;
            }
        }

        // Move both pointers until subLastNode reaches the tail
        while (subLastNode.next != null) {
            subFirstNode = subFirstNode.next;
            subLastNode = subLastNode.next;
        }

        // Perform the rotation
        ListNode newHead = subFirstNode.next;
        subFirstNode.next = null;
        subLastNode.next = head;

        return newHead;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

// @lc code=end

