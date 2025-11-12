import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        return f(n-1,heights);
        
    }

    public static int f(int ind, int [] heights)
    {
        if(ind==0) return 0;
        int left=f(ind-1,heights) + Math.abs(heights[ind]-heights[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1)
        right=f(ind-2,heights) + Math.abs(heights[ind]-heights[ind-2]);
        return Math.min(left,right);

    }

}
