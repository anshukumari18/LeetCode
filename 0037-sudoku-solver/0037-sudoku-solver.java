class Solution {
    int[] rows = new int[9], cols = new int[9], boxes = new int[9];
    List<int[]> empties = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') empties.add(new int[]{i,j});
                else place(i,j,board[i][j]-'1');
            }
        }
        backtrack(board);
    }

    void place(int r,int c,int num){int m=1<<num;rows[r]|=m;cols[c]|=m;boxes[(r/3)*3+c/3]|=m;}
    void remove(int r,int c,int num){int m=~(1<<num);rows[r]&=m;cols[c]&=m;boxes[(r/3)*3+c/3]&=m;}
    int countBits(int n){int c=0;while(n>0){n&=(n-1);c++;}return c;}
    int bitPos(int mask){int p=0;while((1<<p)!=mask)p++;return p;}

    boolean backtrack(char[][] board){
        if(empties.isEmpty()) return true;
        int minOpt=10,idx=-1,mask=0;
        for(int k=0;k<empties.size();k++){
            int[] cell=empties.get(k);int r=cell[0],c=cell[1];
            int b=(r/3)*3+c/3, used=rows[r]|cols[c]|boxes[b];
            int opt=9-countBits(used);
            if(opt<minOpt){minOpt=opt;idx=k;mask=(~used)&0x1FF;if(opt==1)break;}
        }
        int[] cell=empties.remove(idx);int r=cell[0],c=cell[1];
        while(mask!=0){int pick=mask&-mask;int num=bitPos(pick);
            place(r,c,num);board[r][c]=(char)(num+'1');
            if(backtrack(board)) return true;
            remove(r,c,num);board[r][c]='.';mask-=pick;}
        empties.add(idx,cell);return false;
    }
}