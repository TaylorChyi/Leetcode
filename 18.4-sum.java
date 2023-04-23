import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] >= 0 && nums[i] + nums[j] > target) {
                    break;
                }

                if ( nums[j] == nums[j-1] && j > i + 1) {
                    continue;
                }

                int right = nums.length - 1;
                int left = j + 1;
                while (right > left) {
                    long sum = nums[i] + nums[j] + nums[right] + nums[left];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[right], nums[left]));
                        while ( nums[right] == nums[right-1] && right > left) 
                            right--;
    
                        while ( nums[left] == nums[left+1] && left < right)
                            left++;

                        right--;
                        left++;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }

                    
                }
            }
        }

        return result;
    }
}
// @lc code=end

