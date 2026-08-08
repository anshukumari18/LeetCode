class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        char[] arr = s.toCharArray();   // avoid repeated charAt() overhead
        int[] prevIndex = new int[128]; // ASCII lookup table
        
        int left = 0, maxLength = 0;

        for (int right = 0; right < n; right++) {
            char ch = arr[right];
            
            if (prevIndex[ch] > left) {
                left = prevIndex[ch];
            }
            
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            
            prevIndex[ch] = right + 1;
        }

        return maxLength;
    }
}