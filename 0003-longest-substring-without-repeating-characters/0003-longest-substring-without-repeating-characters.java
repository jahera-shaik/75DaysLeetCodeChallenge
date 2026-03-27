class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Array to store the last seen index of each character
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If we've seen this character before and it's within our current window
            if (lastSeen[currentChar] >= left) {
                // Move left pointer to the right of the previous occurrence
                left = lastSeen[currentChar] + 1;
            }
            
            // Update the last seen index of the character
            lastSeen[currentChar] = right;
            
            // Calculate window size and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}