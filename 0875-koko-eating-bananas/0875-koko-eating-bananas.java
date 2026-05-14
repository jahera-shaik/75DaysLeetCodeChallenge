class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // The maximum possible speed needed is the size of the largest pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                // Potential answer, but let's see if we can go slower
                high = mid;
            } else {
                // Too slow, must increase speed
                low = mid + 1;
            }
        }
        
        return low;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            // Ceiling division: (pile + k - 1) / k
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}