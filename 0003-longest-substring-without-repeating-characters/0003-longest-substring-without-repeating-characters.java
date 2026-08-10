class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128]; // store last seen index of each char
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, lastIndex[c]); // move left pointer if repeated
            maxLen = Math.max(maxLen, right - left + 1);
            lastIndex[c] = right + 1; // store index + 1
        }

        return maxLen;
    }
}