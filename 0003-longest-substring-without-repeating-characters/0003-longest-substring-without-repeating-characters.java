class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength = 0;
        int length = s.length();
        int i = 0;
        int map[] = new int[128];
        for(int j =0; j<length ;j++){
            char c = s.charAt(j);
            // jum i forward if found
            i = Math.max(i,map[c]);

            //update max length
            maxlength = Math.max(maxlength,j-i+1);

            map[c] = j+1;

        }
        return maxlength;
    }
}