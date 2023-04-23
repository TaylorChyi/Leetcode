import java.util.Set;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet();
        Set<Integer> res = new HashSet();
        for (int i : nums1) {
            temp.add(i);
        }
        for (int i : nums2) {
            if (temp.contains(i))
                res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

