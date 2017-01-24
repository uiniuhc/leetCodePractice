public class Solution {
    public int findMin(int[] nums) {
        return findMinHelper(nums,0,nums.length-1);
    }
    public int getMin(int a,int b){
        if(a<b){
            return a;
        }
        return b;
    }
    public int findMinHelper(int[] nums , int l ,int r){
        if(l==r){
            return nums[l];
        }
        int mid=(l+r)/2;
        int min=nums[l];
        if(nums[mid]>nums[l]){
            return getMin(findMinHelper(nums,mid+1,r),nums[l]);
        }else if(nums[mid]<nums[l]){
            return getMin(findMinHelper(nums,l+1,mid),nums[r]);
        }else{
            return getMin(findMinHelper(nums,l,mid),findMinHelper(nums,mid+1,r));
        }
    }
}
