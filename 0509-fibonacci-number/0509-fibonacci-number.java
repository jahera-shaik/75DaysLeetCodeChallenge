class Solution {
    public int fib(int n) {
        // Base cases
        if (n <= 1) return n;
        
        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        int current = 0;
        
        // Build the sequence iteratively
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}