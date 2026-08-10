class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastShowIndex = new int[128]; 
        for(int i=0; i<lastShowIndex.length; i++){
            lastShowIndex[i] = -1;
        }
        int max = 0;
        int start = 0;
        int end;
        int length = s.length();
        for (end = 0; end < length; end++) {
            int last = lastShowIndex[s.charAt(end)];
            if (last >= start) { // there is duplication
                max = Math.max(max, end - start);   // current length is end - start (exclusive end)
                start = last+1;
            }
            lastShowIndex[s.charAt(end)] = end;
        }
        if (max < end - start) {
            max = end - start;
        }
        return max;
    }
}