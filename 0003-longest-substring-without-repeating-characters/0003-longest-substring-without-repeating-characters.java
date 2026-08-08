class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        char[] arr = s.toCharArray(); // avoid repeated charAt() overhead
        int[] lastIndex = new int[128];
        java.util.Arrays.fill(lastIndex, -1);
        
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            char c = arr[right];
            int prev = lastIndex[c];
            if (prev >= left) {
                left = prev + 1;
            }
            lastIndex[c] = right;
            int len = right - left + 1;
            if (len > maxLength) maxLength = len;
        }
        
        return maxLength;
    }
}