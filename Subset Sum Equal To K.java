import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean f(int index,int target,int [] arr,int [][]dp)
    {
        if(target==0) return true;
        if(index==0) return arr[0]==target;
        if(dp[index][target]!=-1) return dp[index][target]==1;
        boolean nottake=f(index-1,target,arr,dp);
        boolean take=false;
        if(target>=arr[index])
        {
            take=f(index-1,target-arr[index],arr,dp);
        }
        dp[index][target]=(nottake || take) ? 1 : 0;
        return take||nottake;
    }
    
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int [][]dp=new int[n][k+1];
        for(int []r:dp)
        {
            Arrays.fill(r,-1);
        }

        return f(n-1,k,arr,dp);
    }
}
