import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum coins needed for amount i
        int[] dp = new int[amount + 1];
        
        // Initialize with a value larger than any possible solution
        int max = amount + 1;
        Arrays.fill(dp, max);
        
        // Base case: 0 coins needed for amount 0
        dp[0] = 0;
        
        // Fill the DP table
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still max, then it's impossible to form the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}