import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        // HashMap to store (prefixSum, frequency)
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once (for subarrays starting at index 0)
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists in map, it means there is a subarray summing to k
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Store/update the frequency of the current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}