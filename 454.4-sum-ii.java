import java.util.Arrays;
import java.util.Map;

/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map12 = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            for (int j : nums2) {
                map12.put(i + j, map12.getOrDefault(i + j, 0) + 1);
            }
        }

        // int result = 0;
        // Map<Integer, Integer> map34 = new HashMap<Integer, Integer>();
        // for (int i : nums3) {
        //     for (int j : nums4) {
        //         map34.put(i + j, map34.getOrDefault(i + j, 0) + 1);
        //     }
        // }


        // for (Integer key12 : map12.keySet()) {
        //     result += map12.get(key12) * map34.getOrDefault(-key12, 0);
        // }
        // return result;

        int result = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                result += map12.getOrDefault(-i-j, 0);
            }
        }

        return result;

    }
}
// @lc code=end
