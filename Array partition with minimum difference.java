
public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int totalSum=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=arr[i];

        }
        int k=totalSum;
        boolean[][] dp = new boolean[n][k + 1];

        // Base case: sum=0 can always be formed by empty subset
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: If first element <= k, mark dp[0][arr[0]] true
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table iteratively
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Option 1: Do not take the current element
                boolean notTaken = dp[ind - 1][target];

                // Option 2: Take current element if it does not exceed target
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Mark current cell as true if either option is true
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini=Integer.MAX_VALUE;
        for(int s1=0;s1<=totalSum/2;s1++)
        {
            if(dp[n-1][s1]==true)
            {
                int s2=totalSum-s1;
                mini=Math.min(mini,Math.abs(s1-s2));
            }
        }
        return mini;
    }

    
}
