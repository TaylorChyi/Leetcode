import java.util.HashMap;

/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        // HashMap<Character, Integer> map = new HashMap<>();
        // map.put('A', 1);
        // map.put('B', 2);
        // map.put('C', 3);
        // map.put('D',4);
        // map.put('E', 5);
        // map.put('F', 6);
        // map.put('G', 7);
        // map.put('H', 8);
        // map.put('I', 9);
        // map.put('J', 10);
        // map.put('K', 11);
        // map.put('L', 12);
        // map.put('M', 13);
        // map.put('N', 14);
        // map.put('O', 15);
        // map.put('P', 16);
        // map.put('Q', 17);
        // map.put('R', 18);
        // map.put('S', 19);
        // map.put('T', 20);
        // map.put('U', 21);
        // map.put('V', 22);
        // map.put('W', 23);
        // map.put('X', 24);
        // map.put('Y', 25);
        // map.put('Z', 26);

        // int index = columnTitle.length() - 1;
        // int result = 0;
        // for (char c : columnTitle.toCharArray()) {
        //     result += map.get(c) * Math.pow(26, index--);
        // }

        // return result;

        // if (s == null) return -1;
        int sum = 0;
        // for each loop so we don't need to mess with index values.
        for (char c : columnTitle.toCharArray()) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
// @lc code=end

