public class Solution {
    public int missingNumber(int[] nums) {
        long aim=(0+nums.length)*(nums.length+1)/2;
        long sum=0;
        for(int i:nums)sum+=i;
        return (int)(aim-sum);
    }
}
