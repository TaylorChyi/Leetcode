import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> pool = new HashSet<Integer>();
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            if (!pool.contains(temp)) {
                pool.add(temp);
                n = temp;
            }
            else {
                return false;
            }
        }
        return true;
        
    }
}
// @lc code=end

