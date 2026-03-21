class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;  // Position for next non-zero
        
        // Move all non-zeros to the front
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        
        // Fill remaining positions with zeros
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}