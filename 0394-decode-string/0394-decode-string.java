import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the multiplier (k)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current state to resume later
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the new nested level
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the count and the string built before this bracket
                StringBuilder decodedString = currentString;
                currentString = stringStack.pop();
                int repeatCount = countStack.pop();
                
                // Append the nested content k times
                while (repeatCount-- > 0) {
                    currentString.append(decodedString);
                }
            } else {
                // Regular character: add to current level
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}