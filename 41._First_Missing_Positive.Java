public class Solution {
    public int firstMissingPositive(int[] nums) {
    if(nums==null || nums.length==0)return 1;
    int last=nums.length;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1){
            int t=nums[i];
            if(nums[t-1]==nums[i]){continue;}
            nums[i]=nums[t-1];
            nums[t-1]=t;
            i--;
        }
    }
    for(int i=0;i<nums.length;i++){
        if(nums[i]==i+1)continue;
        return i+1;
    }
    return nums.length+1;
}
}
