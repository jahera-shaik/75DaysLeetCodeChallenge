class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Compare mid with the next element
            if (nums[mid] < nums[mid + 1]) {
                // We are on an upward slope. The peak is to the right.
                low = mid + 1;
            } else {
                // We are on a downward slope. mid could be the peak.
                high = mid;
            }
        }

        // When low == high, we've converged on a peak element index.
        return low;
    }
}