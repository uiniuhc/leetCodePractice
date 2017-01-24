public class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0)return 0;
        int min=nums[0];
        int l=0;int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]<nums[0]){
                min=nums[mid];
                //go to left
                r=mid-1;
            }else{
                //go to right
                l=mid+1;
            }
        }
        return min;
    }
}
