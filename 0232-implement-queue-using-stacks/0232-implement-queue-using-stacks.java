import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // Push element x to the back of the queue - O(1)
    public void push(int x) {
        input.push(x);
    }
    
    // Removes the element from the front of the queue - Amortized O(1)
    public int pop() {
        shiftStacks();
        return output.pop();
    }
    
    // Get the front element - Amortized O(1)
    public int peek() {
        shiftStacks();
        return output.peek();
    }
    
    // Returns whether the queue is empty - O(1)
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    // Helper method to move elements from input to output when needed
    private void shiftStacks() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}