class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean first = false;

        // Phase 1: Mark rows and columns
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                first = true;
            }
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Phase 2: Set zeros based on markers (iterating backwards)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (first) {
                matrix[i][0] = 0;
            }
        }
    }
}