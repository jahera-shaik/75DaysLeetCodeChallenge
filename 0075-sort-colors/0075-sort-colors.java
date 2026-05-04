class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Move 0s to the front
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Keep 1s in the middle
                mid++;
            } else {
                // Move 2s to the end
                swap(nums, high, mid);
                high--;
                // Don't increment mid here because the new nums[mid] 
                // could be a 0 or 1 and needs evaluation.
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}