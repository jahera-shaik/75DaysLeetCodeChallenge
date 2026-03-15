import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Mark presence by negating value at index
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // Get 0-based index
            
            if (nums[index] > 0) {
                nums[index] = -nums[index];  // Mark as seen
            }
        }
        
        // Find positive values (unmarked = missing numbers)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);  // Convert back to 1-based
            }
        }
        
        return result;
    }
}