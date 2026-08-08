import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        // Map stores the character and its last seen index
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                // Jump the start of the window
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            res = Math.max(res, end - start + 1);
            charIndexMap.put(currentChar, end);
        }
        return res;
    }
}