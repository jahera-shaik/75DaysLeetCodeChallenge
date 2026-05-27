class Solution {
    public int findJudge(int n, int[][] trust) {
        // Create an array to track trust scores
        int[] trustScores = new int[n + 1];

        for (int[] t : trust) {
            // Subtract for outgoing trust
            trustScores[t[0]]--;
            // Add for incoming trust
            trustScores[t[1]]++;
        }

        // Check for the person who satisfies the conditions
        for (int i = 1; i <= n; i++) {
            // Judge must be trusted by exactly n-1 people 
            // and trust 0 people (in-degree - out-degree = n-1)
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}