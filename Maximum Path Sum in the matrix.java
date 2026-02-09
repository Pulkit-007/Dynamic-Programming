import java.util.* ;
import java.io.*; 

public class Solution {
	public static int f(int i,int j,int [][]dp,int [][]matrix)
	{
		if(j<0 || j>=matrix[0].length) return (int)-1e8;
		if(i==0) return matrix[0][j];
		if(dp[i][j]!=-1) return dp[i][j];
		int up=matrix[i][j]+f(i-1,j,dp,matrix);
		int ld=matrix[i][j]+f(i-1,j-1,dp,matrix);
		int rd=matrix[i][j]+f(i-1,j+1,dp,matrix);
		return dp[i][j]=Math.max(up,Math.max(ld,rd));
	}
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n=matrix.length;
		int m=matrix[0].length;
		int [][] dp=new int[n][m];
		for(int [] du:dp)
		{
			Arrays.fill(du,-1);
		}	
		int maxi=(int)-1e8;
		for(int j=0;j<m;j++)
		{
			maxi=Math.max(maxi,f(n-1,j,dp,matrix));
		}
		return maxi;

	}
}
