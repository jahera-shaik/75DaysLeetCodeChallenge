import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // Stack will store indices of temperatures
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // While current temperature is warmer than the temperature at the stack's top index
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            // Always push the current index
            stack.push(i);
        }
        
        return result;
    }
}