class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // dp[i] will store the maximum amount robbed up to house i
        int prev2 = 0; // Represents dp[i-2]
        int prev1 = 0; // Represents dp[i-1]
        
        for (int num : nums) {
            // The choice: current house + money from 2 houses ago OR just money from previous house
            int current = Math.max(prev1, num + prev2);
            
            // Shift pointers for next iteration
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}