public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0)return false;
        if(target==nums[0])return true;
        return searchHelper(nums,target,0,nums.length-1);
    }
    
    //find target in the range of l and r
    private boolean searchHelper(int[]nums,int target,int l,int r){
        if(l>r)return false;
        int mid=(l+r)/2;
        if(target==nums[mid])return true;
        if(nums[mid]<nums[0]){
            //from mid to length-1 is increasing
            if(target<nums[mid] || target>nums[0]){
                //it is between l to mid-1
                return searchHelper(nums,target,l,mid-1);
            }
            else{
                return searchHelper(nums,target,mid+1,r);
            }
        }else if(nums[mid]>nums[0]){
            if(target>nums[mid] || target<nums[0]){
                return searchHelper(nums,target,mid+1,r);
            }
            else{
                return searchHelper(nums,target,l,mid-1);
            }
        }else{
            //can't tell the range's distribution!!!
            return searchHelper(nums,target,mid+1,r) || searchHelper(nums,target,l,mid-1);
        }
        
    }
}
