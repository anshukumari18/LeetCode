class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int[] charIdx = new int[128]; //stores idxs of char when the appear
        int start = 0;
        int globalLen = 0;
    
        for (int i=0;i<n;i++){
            char ch = s.charAt(i);
            int preIdx = charIdx[(int)ch];
            start = Math.max(start, preIdx );
            globalLen = Math.max(i-start+1, globalLen);
            charIdx[(int) ch] = i + 1 ; //storing pos of next start if this element is found to avoid default zero problem
        }
        return globalLen;
}}

// //while loop to find start is not optimal - but still a good solution
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length() <= 1) return s.length();
//         HashSet<Character> hs = new HashSet<>();

//         int start = 0;
//         int globalLen = 0;
//         int windowLen = 0;

//         for (Character c: s.toCharArray()){
//             if (hs.contains(c)){
//                 globalLen = Math.max(windowLen, globalLen);
//                 //bring start to the point at which char existed before
//                 while (s.charAt(start) != c){
//                     hs.remove(s.charAt(start)); //removing elemets is important
//                     start++;
//                     windowLen--;
//                 }
//                 start++;
//             }else{
//                 hs.add(c);
//                 windowLen++;
//             }
//         }
//         return Math.max(globalLen,windowLen) ;
//     }
// }

/*old code
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Map<Character, Integer > hm = new HashMap<>();
        int max = 0;
        int start = 0;
        int i = 0;
        for (Character c: s.toCharArray()){
            if (hm.containsKey(c)){
                int localMax = i - start;
                if (localMax > max){
                    max = localMax;
                }
                
                start = hm.get(c) + 1 < start ? start :hm.get(c) + 1 ;
            }
            hm.put(c,i);
            i++;
        }
        int localMax = i - start;
        if (localMax > max){
            max = localMax;
        }


        return max;

        
    }
}


*/