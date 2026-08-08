class Solution {
    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);       // odd-length palindromes (single center)
            expandAroundCenter(s, i, i + 1);   // even-length palindromes (double center)
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // At this point, s[left+1 ... right-1] is the palindrome (left/right overshot by 1)
        int currentLength = right - left - 1;
        if (currentLength > maxLength) {
            maxLength = currentLength;
            start = left + 1;
        }
    }
}