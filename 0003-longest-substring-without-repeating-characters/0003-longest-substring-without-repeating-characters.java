class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int max = 0, start = 0;
  for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            freq[ch]++;
                 while (freq[ch] > 1) {
                freq[s.charAt(start)]--;
                start++;
            }
   int len = end - start + 1;
            if (len > max) max = len;
        }
  return max;
    }
}