// Approach - 1 Memorization
class Solution {
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int [] [] dp = new int[n][m];
        for(int [] i: dp)Arrays.fill(i,-1);
        return solve (n-1,m-1,grid,dp);        
    }
    int solve (int i, int j, int [][] grid, int [][] dp){
        
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int)(1e9);

        if(dp[i][j]!=-1) return dp[i][j];

        int left = grid[i][j] + solve(i,j-1,grid,dp);
        int up = grid[i][j] + solve(i-1,j,grid,dp);

        return dp[i][j] = Math.min(left,up);
    }
}