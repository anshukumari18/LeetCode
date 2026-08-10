class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[255];
        Arrays.fill(hash, -1);
        int l=0, r=0, maxlen=0;
        int n = s.length();
        while (r < n) {
            char ch = s.charAt(r);
            if (hash[ch] != -1 && hash[ch] >= l) {
                l = hash[ch] + 1;
            } 
            int len = r - l + 1;
            maxlen = Math.max(maxlen, len);
            hash[ch] = r;
            r++;
        }
        return maxlen;
    }
}