import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	// public static int f(int ind,ArrayList<Integer> nums,int []dp)
	// {
	// 	if(ind==0) return nums.get(ind);
	// 	if(ind<0) return 0;
	// 	if(dp[ind]!=-1) return dp[ind];
	// 	int pick=nums.get(ind)+f(ind-2,nums,dp);
	// 	int notpick=0+f(ind-1,nums,dp);
	// 	return dp[ind]=Math.max(pick,notpick);
	// }



	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		int prev=nums.get(0);
		int prev2=0;
		for(int i =1;i<n;i++)
		{
			int pick=nums.get(i); 
			if(i>1) pick+=prev2;
			int notpick=0+prev;
			int curri=Math.max(pick,notpick);
			prev2=prev;
			prev=curri;
		}
		return prev;
	}
}
