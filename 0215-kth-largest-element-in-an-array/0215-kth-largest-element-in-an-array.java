import java.util.Random;

class Solution {
    private Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int left, int right, int kIndex) {
        if (left == right) return nums[left];

        // Randomly pick a pivot to avoid O(n^2) on sorted/partially sorted inputs
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = nums[pivotIndex];

        // 3-Way Partitioning
        int lt = left, gt = right, i = left;
        while (i <= gt) {
            if (nums[i] > pivotValue) swap(nums, lt++, i++);
            else if (nums[i] < pivotValue) swap(nums, i, gt--);
            else i++;
        }

        // Now nums[lt...gt] are all equal to pivotValue
        if (kIndex >= lt && kIndex <= gt) return nums[kIndex];
        else if (kIndex < lt) return quickSelect(nums, left, lt - 1, kIndex);
        else return quickSelect(nums, gt + 1, right, kIndex);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}