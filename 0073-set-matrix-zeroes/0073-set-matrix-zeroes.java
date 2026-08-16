class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int col1 = 1;

        // Mark Zeros
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(j == 0 && matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    col1 = 0;
                }
                else if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set Zeros
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 1;i < n;i++){
                matrix[0][i] = 0;
            }
        }
        if(col1 == 0){
            for(int i = 0;i < m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}