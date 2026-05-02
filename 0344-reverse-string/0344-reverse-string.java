class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Standard swap using a temporary variable
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move the pointers toward the center
            left++;
            right--;
        }
    }
}