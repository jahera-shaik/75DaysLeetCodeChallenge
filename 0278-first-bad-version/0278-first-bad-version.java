/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            // Standard mid calculation that prevents overflow
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                // This could be the first bad version, or it's further left
                high = mid;
            } else {
                // Everything up to mid is good, so look right
                low = mid + 1;
            }
        }

        // Both low and high will point to the first bad version
        return low;
    }
}