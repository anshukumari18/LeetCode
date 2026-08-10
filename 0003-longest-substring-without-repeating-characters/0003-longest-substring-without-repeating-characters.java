class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int ans = 0;
        int freq[] = new int[128];

        while(r < s.length()){
            if(l < r && freq[s.charAt(r)] == 1){
                freq[s.charAt(l)] = 0;
                l++;
            } else {
                freq[s.charAt(r)] = 1;
                r++;
                ans = Math.max(ans, (r - l));
            }
        }

        return ans;
        
    }
}