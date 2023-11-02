/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) return new ArrayList<String>();

        List<String> results = new ArrayList<String>();

        backTrackRestoreIpAddresses(0, s, 
                                    new ArrayList<>(), results);

        return results;
    }

    public void backTrackRestoreIpAddresses(int startIndex, 
                                            String sample, 
                                            List<String> items, 
                                            List<String> results) {
        if (items.size() == 4) {
            if (startIndex == sample.length()) {
                results.add(String.join(".", items));
            }
            return;
        }                
        

        for (int i = startIndex; i < startIndex + 3 && i < sample.length(); i++) {
            String ipPartition = sample.substring(startIndex, i + 1);
            if (isValidIpPartition(ipPartition)) {
                items.add(ipPartition);
                backTrackRestoreIpAddresses(i + 1, sample, items, results);
                items.remove(items.size() - 1);
            }
            else {
                break;
            }
        }
    }

    public boolean isValidIpPartition(String ipPartition) { 
        if (ipPartition.length() > 3) {
            return false;
        }
        if (ipPartition.startsWith("0") && ipPartition.length() > 1) {
            return false;
        }
        int value = Integer.parseInt(ipPartition);
        return value >= 0 && value <= 255;
        // // 1. 长度是1的时候，任何数字都可以
        // // 2. 长度是大于1的时候，首位不可以是0
        // // 3. 
        // int temp = Integer.parseInt(ipPatition);
        // return  ipPatition.length() == 1 ||
        //         (ipPatition.length() > 1 && ipPatition.length() < 4 && ipPatition.charAt(0) != '0') && 
        //         temp >= 0 &&
        //         temp <= 255;
    }
    // public void backTrackRestoreIpAddresses(int startIndex, int itemIndex, String sample, List<Integer> items, List<String> results) {
    //     if (itemIndex == 3 && startIndex == sample.length()) {
    //         results.add(items.get(0) + "." + items.get(1) + "." + items.get(2) + "." + items.get(3));
    //         return;
    //     }

    //     for (int i = startIndex; i < sample.length(); i++) {
    //         if (startIndex > 0 && items.get(0) == -1) return;

    //         itemIndex = appendIpAddress(items, sample.charAt(i) - '0', itemIndex);
            
    //         backTrackRestoreIpAddresses(i + 1, itemIndex, sample, items, results);
            
    //         itemIndex = removeLastDigitInIpAddress(items, sample.charAt(i) - '0', itemIndex);
    //     }
    // }

    // public int appendIpAddress(List<Integer> items, int digit, int itemIndex) {
    //     if (items.get(itemIndex) == 0 && digit == 0) {
    //         items.set(itemIndex + 1, digit);
    //         return itemIndex + 2;
    //     }

    //     if (items.get(itemIndex) == -1) {
    //         items.set(itemIndex, digit);
    //     }
    //     else {
    //         int value = items.get(itemIndex) * 10 + digit;
    //         if (value > 255) {
    //             itemIndex++;
    //             items.set(itemIndex, digit);
    //         }
    //         else {
    //             items.set(itemIndex, value);
    //         }
    //     }
        

    //     return itemIndex;
    // }

    // public int removeLastDigitInIpAddress(List<Integer> items, int digit, int itemIndex) {
    //     int value = items.get(itemIndex) / 10;

    //     if (value == 0) {
    //         value = -1;
    //         itemIndex--;
    //     }
    //     if (itemIndex < 0) itemIndex++;

    //     items.set(itemIndex, value);

    //     return itemIndex;
    // }
}
// @lc code=end

