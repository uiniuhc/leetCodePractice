public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1)return true;
        boolean[] canReach=new boolean[nums.length];
        canReach[nums.length-1]=true;
        int comeHere=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=comeHere){
                canReach[i]=true;
                comeHere=i;
            }
        }
        return canReach[0];
    }
}
