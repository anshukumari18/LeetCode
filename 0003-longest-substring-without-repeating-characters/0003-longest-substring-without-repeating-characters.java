class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int start = 1; // Start of the valid substring
        int ret = 0;   // Stores max length found
        int cur = 0;   // Current length of valid substring
        int[] position = new int[128]; // Tracks last seen index of each character

        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            // If character is found again within the valid window, update start
            if (position[c] >= start) {
                start = position[c] + 1;
                cur = i + 2 - start; // Adjust current length
            } else {
                cur += 1;
                ret = Math.max(ret, cur); // Update max length
            }
            position[c] = i + 1; // Update character's last seen position
        }
        return ret;
    }
}