class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current width and height
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            
            // Update max area
            maxArea = Math.max(maxArea, h * width);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}