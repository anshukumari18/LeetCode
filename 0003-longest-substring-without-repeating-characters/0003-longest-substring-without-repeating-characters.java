class Solution {
    public int lengthOfLongestSubstring(String s) {
       int l = 0, r = 0;
       int len = 0, maxlen = 0;
       int hash[] = new int[256];
       java.util.Arrays.fill(hash, -1);

       for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(hash[c] != -1) {
                if(hash[c] >= l) {
                    l = hash[c] + 1;
                }
            }

            len = r-l+1;
            maxlen = Math.max(len, maxlen);
            hash[c] = r;
            r++;
       }

        return maxlen;
    }
}