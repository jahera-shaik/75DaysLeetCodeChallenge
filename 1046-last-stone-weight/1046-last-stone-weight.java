import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Initialize a Max-Heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Push all stones into the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Process until 0 or 1 stone remains
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest stone
            int x = maxHeap.poll(); // Second heaviest stone

            if (x != y) {
                maxHeap.add(y - x); // Put the smashed remainder back
            }
        }

        // Return the final element or 0 if heap is empty
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}