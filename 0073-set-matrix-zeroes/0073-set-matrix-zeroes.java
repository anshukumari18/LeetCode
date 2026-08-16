class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row1 = -1, col1 = -1;

        // Step 1: check if first row has zero
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                row1 = 0;
                break;
            }
        }

        // Step 2: check if first column has zero
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col1 = 0;
                break;
            }
        }

        // Step 3: mark rows and cols (skip first row and col)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Step 4: set rows to zero
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: set columns to zero
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 6: handle first row & col separately
        if (row1 == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col1 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}