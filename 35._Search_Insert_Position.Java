public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0)return 0;
        if(target<nums[0])return 0;
        else if(target>nums[nums.length-1])return nums.length;
        int l=0;int r=nums.length-1;
        int res=0;
        while(l<=r){
            int mid=(l+r)/2;
            if(target==nums[mid])return mid;
            else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
                res=mid;
            }
        }
        return res;
    }
}
