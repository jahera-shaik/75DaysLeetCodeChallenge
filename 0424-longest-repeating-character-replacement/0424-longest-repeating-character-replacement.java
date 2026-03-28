class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // To store frequency of uppercase English letters
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Update frequency of current character
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;
            
            // Keep track of the most frequent character in the current window
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);
            
            // Window size is (right - left + 1)
            // If (size - maxFreq) > k, we have more than k 'other' characters
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                // Note: We don't strictly need to update maxFreq here 
                // because maxLength only increases when maxFreq increases.
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}