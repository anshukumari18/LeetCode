import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) { // Closing bracket
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else { // Opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}