class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the high element, 
            // the minimum must be in the right half.
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // Otherwise, the minimum is either at mid or in the left half.
            else {
                high = mid;
            }
        }

        // When low == high, we've converged on the minimum element.
        return nums[low];
    }
}