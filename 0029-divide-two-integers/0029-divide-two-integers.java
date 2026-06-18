class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        // Work with long to prevent overflow during absolute value conversion
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        int quotient = 0;
        
        // Repeatedly subtract the largest possible power-of-2 multiple
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            int multiple = 1;
            
            // Shift divisor left until it's just below dividend
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            absDividend -= temp;
            quotient += multiple;
        }
        
        return isNegative ? -quotient : quotient;
    }
}