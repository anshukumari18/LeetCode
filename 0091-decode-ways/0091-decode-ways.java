class Solution {
    public int numDecodings(String s) {
        //safety checks
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return decode(n-1,s,dp);
    }
    private int decode(int pos, String str, int []dp){
        // safety check
        if(pos < 0){
            return 1;
        }
            //Base case
            if(pos == 0)
                if(str.charAt(0) == '0') return 0;
                else return 1;
            //Lookup and if already computed return from dp[]
            if(dp[pos] != -1){
                return dp[pos];
            }    
            // Recursive relation
            int individual=0;
            if(str.charAt(pos) == '0')
                individual =0;
            else
            // recursively call for prev number to find 2nd ways
                individual = 1*decode(pos-1, str, dp);        
            int pair =0;
            // if your prev digit is 0
            if(str.charAt(pos-1) == '0'){
                pair =0;
                // No Alphabets that starts after 27, 26=z is the last
            }else if(str.charAt(pos-1) > '2'){
                pair =0;
            }else if(str.charAt(pos-1) == '2'){
                // if charAt last index < 7, no other char found after 7
                if(str.charAt(pos) < '7'){
                    pair = 1 * decode(pos-2, str, dp);
                }else{
                    pair =0;
                }
                // if it is single character
            }else if(str.charAt(pos-1) == '1'){
                pair = 1 * decode(pos-2, str, dp);
            } 
         dp[pos] = individual + pair;
         return dp[pos];      
    }
}