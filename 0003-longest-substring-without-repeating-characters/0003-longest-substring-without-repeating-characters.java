class Solution {
    public int lengthOfLongestSubstring(String s) {
        // We'll use a "set" to remember which letters we've seen in the current substring.
        // Think of it as a VIP list for letters - no duplicates allowed! 🚫
        Set<Character> set = new HashSet<>();

        // This will keep track of the longest substring we've found so far.
        int maxLen = 0;

        // 'left' will point to the beginning of our current substring.
        // It's like marking where our treasure hunt starts. 🗺️
        int left = 0;

        // This loop goes through the entire string, letter by letter.
        // 'right' is our explorer, checking out each letter one by one. 🚶
        for (int right = 0; right < s.length(); right++) {
            // Get the current letter that the explorer is looking at.
            char c = s.charAt(right);

            // Uh oh! We've already seen this letter in our current substring! 😱
            // We need to shrink our substring from the left until we don't have duplicates anymore.
            while (set.contains(c)) {
                // Remove the leftmost letter from our set.
                set.remove(s.charAt(left));
                // Move the 'left' pointer one step to the right, shrinking our substring.
                left++;
            }

            // Now that we've removed any duplicates, we can safely add the current letter to our set.
            set.add(c);

            // Check if our current substring is longer than the longest one we've found so far.
            // If it is, update 'maxLen'.
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Finally, return the length of the longest substring we found. 🎉
        return maxLen;
    }
}