class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        // Pruning: if board doesn't contain enough characters
        int[] freq = new int[128];
        for (char[] row : board) {
            for (char c : row) freq[c]++;
        }

        for (char c : word.toCharArray()) {
            if (--freq[c] < 0) return false;
        }

        // Start from the rarer end of the word
        if (count(board, word.charAt(0)) > count(board, word.charAt(word.length() - 1))) {
            word = new StringBuilder(word).reverse().toString();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;

        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found =
                dfs(board, word, r + 1, c, idx + 1) ||
                dfs(board, word, r - 1, c, idx + 1) ||
                dfs(board, word, r, c + 1, idx + 1) ||
                dfs(board, word, r, c - 1, idx + 1);

        board[r][c] = temp; // backtrack
        return found;
    }

    private int count(char[][] board, char ch) {
        int cnt = 0;
        for (char[] row : board) {
            for (char c : row) {
                if (c == ch) cnt++;
            }
        }
        return cnt;
    }
}