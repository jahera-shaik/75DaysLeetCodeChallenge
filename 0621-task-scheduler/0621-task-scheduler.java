import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }

        // Step 2: Find how many tasks have the same max frequency
        int countOfMaxFreq = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                countOfMaxFreq++;
            }
        }

        // Step 3: Calculate based on frame theory
        // We have (maxFreq - 1) cycles of length (n + 1)
        // Plus the tasks that share the max frequency
        int intervals = (maxFreq - 1) * (n + 1) + countOfMaxFreq;

        // Step 4: The answer is at least the total number of tasks
        return Math.max(intervals, tasks.length);
    }
}