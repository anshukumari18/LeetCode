class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] index = new int[128]; // ASCII map, stores last seen index+1
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // if char seen before AND its last position is within current window
            left = Math.max(index[c], left);
            maxLen = Math.max(maxLen, right - left + 1);
            index[c] = right + 1;
        }
        
        return maxLen;
    }
}