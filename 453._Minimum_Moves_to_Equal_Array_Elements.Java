public class Solution {
    public int minMoves(int[] nums) {
        long sum=0;
        long min=Integer.MAX_VALUE;
        for(int i:nums){
            sum+=i;
            if(i<min)min=i;
        }
        int res=(int)(sum-nums.length*min);
        return res;
    }
}
