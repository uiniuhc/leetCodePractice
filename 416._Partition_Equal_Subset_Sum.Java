public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length<2)return false;
        int total=0;
        for(int i:nums)total+=i;
        if(total%2==1)return false;
        int sum=total/2;
        int[][] canSum=new int[nums.length][sum+1];
        return hasSum(nums,sum,0,canSum);
    }
    
    private boolean hasSum(int[] nums, int total,int from,int[][] canSum){
        if(total==0) return true;
        if(from>=canSum.length) return false;
        if(total<0)return false;
        
        if(canSum[from][total]>0) return true;
        else if(canSum[from][total]<0) return false;
        
        if(hasSum(nums,(total-nums[from]),from+1,canSum) ||
        hasSum(nums,total,from+1,canSum)){
            canSum[from][total]=1;return true;
        }else{
            canSum[from][total]=-1;return false;
        }
    }
}
