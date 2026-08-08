class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;

        // Array to store the last seen index + 1 of each character
        int[] prevIndex = new int[128];

        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            
            // Move left pointer to the right of the last seen duplicate
            left = Math.max(left, prevIndex[ch]);
            
            // Calculate and update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);

            // Record the next index position for this character
            prevIndex[ch] = right + 1;
        }

        return maxLength;
    }
}