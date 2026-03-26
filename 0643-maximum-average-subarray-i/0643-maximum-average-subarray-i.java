class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxSum = currentSum;

        // Slide the window from k to the end of the array
        for (int i = k; i < nums.length; i++) {
            // Add the new element (nums[i]) and remove the oldest (nums[i - k])
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the average
        return maxSum / k;
    }
}