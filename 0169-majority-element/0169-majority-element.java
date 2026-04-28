
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // If count is zero, we pick a new potential candidate
            if (count == 0) {
                candidate = num;
            }

            // If the current number matches candidate, they gain "strength"
            // Otherwise, they "fight" and count decreases
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // The problem guarantees a majority element exists, 
        // so candidate is our answer.
        return candidate;
    }
}