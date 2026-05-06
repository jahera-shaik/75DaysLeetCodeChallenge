class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // While the current window meets the target, try to shrink it
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                
                // Subtract the element at 'left' and move the pointer
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength remained MAX_VALUE, no valid subarray was found
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}