/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start

import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k == 0 || nums.length == 0) return false;

        Set<Integer> window = new HashSet<Integer>();

        for (int cursor = 0; cursor < nums.length; cursor++) {
            if (cursor > k) {
                window.remove(nums[cursor - k - 1]);
            }
            
            if (!window.add(nums[cursor]))
                return true;
        }

        return false;
    }
}
// @lc code=end

