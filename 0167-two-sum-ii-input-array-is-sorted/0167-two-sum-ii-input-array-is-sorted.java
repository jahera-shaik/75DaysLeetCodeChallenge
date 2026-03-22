class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;  // Need larger sum
            } else {
                right--;  // Need smaller sum
            }
        }
        
        return new int[]{};  // No solution (won't happen per problem)
    }
}