class Solution {

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {

        memo = new Boolean[s.length() + 1][p.length() + 1];

        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {

        // Already computed
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Pattern finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Check current match
        boolean firstMatch = (
            i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
        );

        boolean ans;

        // Check for '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // 1. Skip x*
            // 2. Use x* if matched
            ans = dp(i, j + 2, s, p) ||
                  (firstMatch && dp(i + 1, j, s, p));

        } else {

            ans = firstMatch &&
                  dp(i + 1, j + 1, s, p);
        }

        memo[i][j] = ans;
        return ans;
    }
}