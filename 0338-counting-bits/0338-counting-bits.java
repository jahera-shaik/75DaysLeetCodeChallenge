class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        // Base case: ans[0] = 0 is implicitly handled by array initialization
        for (int i = 1; i <= n; i++) {
            // ans[i >> 1] gets the count of set bits in the number without the last bit
            // (i & 1) checks if the last bit is a 1
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}