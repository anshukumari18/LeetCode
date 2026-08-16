class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstrowhaszero=false;
        boolean firstcolhaszero=false;
        int row=matrix.length;
        int col=matrix[0].length;
         // STEP1:CHECK FIRST ROW HAS ZERO 
        for(int j=0;j<col;j++){
          if(matrix[0][j]==0){
            firstrowhaszero=true;
            break;
          }
        }
        //  STEP2:CHECK FIRST COL HAS ZEROES
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0){
                firstcolhaszero=true;break;
            }
        }
        // STEP3:NOW USE THE FIRST ROW AND COL AS A MARKER FOR FILLING THE ENTIRE ROW WITH ZEROES
        // IF WE FOUND ANY ZERO INBETWEEN THE ROWS AND COLUMNS WITH ZEROES THEN MARK THE FIRST ROW&COL WITH ZERO
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        // STEP4:NOW FILL ZEROES WITH THE MARKERSS......
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                     matrix[i][j]=0;
            }
        }
        //STEP-5:NOW FILL FIRST ROW IF FIRST ROW HAS ZERO
        if(firstrowhaszero){
            for(int j=0;j<col;j++){
                matrix[0][j]=0;
            }
        }
        //STEP-6:NOW FILL FIRST COL IF FIRST COL HAS ZERO
        if(firstcolhaszero){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }}


        

        











      