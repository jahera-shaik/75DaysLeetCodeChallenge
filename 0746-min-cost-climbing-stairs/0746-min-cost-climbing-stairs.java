class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // We can start at index 0 or index 1, so the costs to "reach" these are just the costs themselves.
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        // Iterate from step 2 to the end
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }
        
        // To reach the "top" (past the last step), we can come from the last or second-to-last step
        return Math.min(prev1, prev2);
    }
}