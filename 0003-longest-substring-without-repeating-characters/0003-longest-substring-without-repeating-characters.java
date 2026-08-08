class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int max = 0;
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            for(int j = 0;j < sb.length();j++){
                if(c == sb.charAt(j)){
                    String str = sb.substring(j+1,sb.length());
                    sb = new StringBuilder(str);
                    break;
                }
            }
            sb.append(c);
            max = Math.max(max,sb.length());
        }
        return max;
    }
}