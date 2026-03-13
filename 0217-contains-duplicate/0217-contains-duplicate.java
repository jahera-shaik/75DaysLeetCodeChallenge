import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;  // Found duplicate
            }
            seen.add(num);
        }
        
        return false;  // No duplicates
    }
}