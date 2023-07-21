/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (Integer key : frequencyMap.keySet()) {
            if (pq.size() < k) {
                pq.add(new int[] { key, frequencyMap.get(key) });
            }
            else if (frequencyMap.get(key) > pq.peek()[1]) {
                pq.add(new int[] { key, frequencyMap.get(key) });
                pq.poll();
            }

        }

        int[] result = new int[k];
        int index = 0;
        for (int[] i : pq) {
            result[index] = i[0];
            index++;
        }
        return result;

    }
}
// @lc code=end
