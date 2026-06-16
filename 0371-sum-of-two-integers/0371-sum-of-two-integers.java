class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Calculate the carry: AND the bits and shift left
            int carry = (a & b) << 1;
            
            // Calculate the sum without carry: XOR the bits
            a = a ^ b;
            
            // Move carry to b so it can be added in the next iteration
            b = carry;
        }
        return a;
    }
}