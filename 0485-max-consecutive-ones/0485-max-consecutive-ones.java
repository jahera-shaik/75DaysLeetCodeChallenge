class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : nums) {
            if (num == 1) {
                // Found a 1, increment the current streak
                currentCount++;
            } else {
                // Found a 0, update max and reset current streak
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        
        // Final comparison in case the array ends with a streak of 1s
        return Math.max(maxCount, currentCount);
    }
}