class Solution {
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int i, int j) {

        // Memo check
        if (dp[i][j] != null)
            return dp[i][j];

        // Pattern finished
        if (j == p.length())
            return dp[i][j] = (i == s.length());

        // String finished
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        char pc = p.charAt(j);

        // Case 1: '*'
        if (pc == '*') {
            return dp[i][j] =
                    match(s, p, i, j + 1) ||   // zero characters
                    match(s, p, i + 1, j);     // one or more characters
        }

        // Case 2: '?' or exact match
        if (pc == '?' || s.charAt(i) == pc) {
            return dp[i][j] = match(s, p, i + 1, j + 1);
        }

        return dp[i][j] = false;
    }
}