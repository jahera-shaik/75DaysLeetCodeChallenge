public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        
        for (int i = 0; i < 32; i++) {
            // 1. Shift result to the left to make room
            ans <<= 1;
            
            // 2. Get the last bit of n and add it to ans
            ans |= (n & 1);
            
            // 3. Shift n to the right to process the next bit
            n >>= 1;
        }
        
        return ans;
    }
}