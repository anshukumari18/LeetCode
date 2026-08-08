class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j] = true if s[i..m) matches p[j..n)
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true; // empty string matches empty pattern

        // Fill from bottom-right to top-left
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean firstMatch = (i < m) &&
                        (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    // Option 1: skip "x*" entirely (zero occurrences)
                    // Option 2: use one occurrence of x and stay on same pattern position
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}