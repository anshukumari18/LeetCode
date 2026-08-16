class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] markRow = new int[n];
        int[] markCol = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow[i]=1;
                    markCol[j]=1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(markRow[i]==1 || markCol[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}