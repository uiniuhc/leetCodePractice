public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)return 0;
        int[] best =new int[nums.length];
        best[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(best[i-1]>0){
                best[i]=best[i-1]+nums[i];
            }else{
                best[i]=nums[i];
            }
            if(best[i]>max){
                max=best[i];
            }
        }
        return max;
    }
}
