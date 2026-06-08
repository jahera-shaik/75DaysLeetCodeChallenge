import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int x : nums) {
            // Binary search for the first element in tails >= x
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            
            // Replace the found element or append to the end
            tails[i] = x;
            if (i == size) size++;
        }
        
        return size;
    }
}