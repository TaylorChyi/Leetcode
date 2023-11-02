/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ranges = new ArrayList<String>();

        if (nums.length == 0) return ranges;
        if (nums.length == 1) {
            ranges.add(getRange(nums[nums.length - 1], nums[nums.length - 1]));
            return ranges;
        }


        int start = nums[0];
        int end = nums[0];
        for (int current = 1; current < nums.length-1; current++) {
            if (end + 1 == nums[current]) {
                end++;
            }
            else {
                ranges.add(getRange(start, end));
                start = end = nums[current];
            }
        }

        if (end + 1 == nums[nums.length - 1]) {
            end++;
            ranges.add(getRange(start, end));
        }
        else {
            ranges.add(getRange(start, end));
            ranges.add(getRange(nums[nums.length - 1], nums[nums.length - 1]));
        }

        return ranges;
    }

    public String getRange(int start, int end) {
        if (start == end) 
            return start + "";
        else 
            return start + "->" + end;
    }
}
// @lc code=end

