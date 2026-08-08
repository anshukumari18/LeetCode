class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128]; // ASCII characters
        java.util.Arrays.fill(lastIndex, -1);
        
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If character was seen before and is within current window, move left pointer
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            
            lastIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}