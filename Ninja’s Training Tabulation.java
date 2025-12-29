import java.util.*;
public class Solution {

    public static int f(int day, int last, int [][] points,int [][] dp)
    {
        if(dp[day][last]!=-1) return dp[day][last];

        if(day==0)
        {
            int maxi=0;
            for(int task=0;task<3;task++)
            {
                if(task!=last)
                {
                    maxi=Math.max(maxi,points[0][task]);
                }
            }
            return dp[day][last]=maxi;
        }
        int maxi=0;
        for(int task=0;task<3;task++)
        {
            if (task!=last)
            {
                int point=points[day][task]+f(day-1,task,points,dp);
                maxi=Math.max(maxi,point);
            }
        }
        return dp[day][last]=maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..

        int [][] dp=new int[n][4];
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][1],points[0][0]);
        dp[0][3]=Math.max(points[0][1],Math.max(points[0][2],points[0][0]));
        for(int day=1;day<n;day++)
        {
            for(int last=0;last<4;last++)
            {
                dp[day][last]=0;
                for(int task=0;task<3;task++)
                {
                    if(task!=last){
                        int point=points[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];

    }

}
