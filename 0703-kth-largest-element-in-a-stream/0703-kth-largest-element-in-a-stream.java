import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // In Java, PriorityQueue is a Min-Heap by default
        this.minHeap = new PriorityQueue<>(k);

        // Populate the heap with initial array values
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // If our window of size k isn't filled yet, add unconditionally
        if (minHeap.size() < k) {
            minHeap.add(val);
        } 
        // If the new element is larger than the k-th largest element so far
        else if (val > minHeap.peek()) {
            minHeap.poll(); // Evict the old k-th largest
            minHeap.add(val);  // Push the new contender into the top k pool
        }
        
        // The root of the min-heap is always the k-th largest element in the stream
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */