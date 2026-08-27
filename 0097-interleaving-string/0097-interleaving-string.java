class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();
        char[] s3a = s3.toCharArray();
        Boolean[][] dp = new Boolean[s1a.length + 1][s2a.length + 1];

        if ((s1a.length + s2a.length) != s3a.length) {
            return false;
        }
        return isInterleave(dp, 0, 0, 0, s1a, s2a, s3a);
    }

    public boolean isInterleave(Boolean[][] dp,
            int index, int s1i, int s2i,
            char[] s1a, char[] s2a, char[] s3a) {

        if (index == s3a.length) {
            return true;
        }

        if (dp[s1i][s2i] != null) {
            return dp[s1i][s2i];
        }

        boolean s1Valid = s1i < s1a.length && s1a[s1i] == s3a[index];
        boolean s2Valid = s2i < s2a.length && s2a[s2i] == s3a[index];

        boolean ans = false;

        if (s1Valid && s2Valid) {
            ans = isInterleave(dp, index + 1, s1i + 1, s2i, s1a, s2a, s3a)
               || isInterleave(dp, index + 1, s1i, s2i + 1, s1a, s2a, s3a);
        } else if (s1Valid) {
            ans = isInterleave(dp, index + 1, s1i + 1, s2i, s1a, s2a, s3a);
        } else if (s2Valid) {
            ans = isInterleave(dp, index + 1, s1i, s2i + 1, s1a, s2a, s3a);
        }

        dp[s1i][s2i] = ans;
        return ans;
    }
}