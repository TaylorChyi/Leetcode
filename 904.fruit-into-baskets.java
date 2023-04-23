// import java.util.HashMap;
// import java.util.Map;

/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;
        
        for (int fruit : fruits) {
            if (fruit == lastFruit || fruit == secondLastFruit)
                currMax++;
            else
                currMax = lastFruitCount + 1; // last fruit + new fruit
            
            if (fruit == lastFruit)
                lastFruitCount++;
            else {
                lastFruitCount = 1; 
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            
            max = Math.max(max, currMax);
        }
        
        return max;

        // int front = 0;
        // int back = 0;
        // int result = 0;

        // int fruit1 = -1;
        // int fruit2 = -1;
        // int count1 = 0;
        // int count2 = 0;
        // int currentSum = 0;

        // while (back < fruits.length) {
        //     int currentFruit = fruits[back];

        //     if (fruit1 == -1 || currentFruit == fruit1) {
        //         fruit1 = currentFruit;
        //         count1++;
        //         currentSum++;
        //         back++;
        //         result = Math.max(result, currentSum);

        //     } else if (fruit2 == -1 || currentFruit == fruit2) {
        //         fruit2 = currentFruit;
        //         count2++;
        //         currentSum++;
        //         back++;
        //         result = Math.max(result, currentSum);

        //     } else {
        //         currentFruit = fruits[front];

        //         if (currentFruit == fruit1) {
        //             count1--;
        //             if (count1 == 0) {
        //                 fruit1 = -1;
        //             }
        //         } 
        //         else {
        //             count2--;
        //             if (count2 == 0) {
        //                 fruit2 = -1;
        //             }
        //         }
        //         currentSum--;
        //         front++;
        //     }

        // }

        // return result;

        
    }
}
// @lc code=end

