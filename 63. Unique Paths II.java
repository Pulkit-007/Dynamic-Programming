class Solution {
    public static int f(int i,int j, int [][] matrix, int [][] dp)
    {
        if (i>=0 && j>=0 && matrix[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,matrix,dp);
        int left=f(i,j-1,matrix,dp);
        return dp[i][j]=up+left;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][] dp=new int[m][n];
        for(int [] r: dp)
        {
            Arrays.fill(r,-1);
        }
        return f(m-1,n-1,obstacleGrid,dp);

        
    }
}
