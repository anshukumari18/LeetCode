class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean isHere[] = new boolean[128]; // Tracks if a character is in the substring
        int maxLen = 0, l = 0, r = 0;

        while (r < s.length()) {
            if (!isHere[s.charAt(r)]) { // If the character is not in the substring
                isHere[s.charAt(r)] = true;
                r++;
                maxLen = Math.max(maxLen, r - l); // Update max length
            } else { // If it's a duplicate, remove characters from the left
                isHere[s.charAt(l)] = false;
                l++;
            }
        }

        return maxLen;
    }
}