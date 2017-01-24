public class Solution {
    public int search(int[] nums, int target) {
        
        //use binary search
        int l,r,mid;
        l=0;r=nums.length-1;
        while(l<=r){
            mid=(l+r)/2;
            if(target>nums[mid]){
                if(nums[mid]>=nums[0]){
                    //increasing so far,find right half
                    l=mid+1;
                }else{
                    //this node is
                    if(target>nums[nums.length-1]){
                        //in the left side
                        r=mid-1;
                    }else{
                        //in the right side
                        l=mid+1;
                    }
                }
            }
            else if(target<nums[mid]){
                if(nums[mid]<nums[0]){
                    //decreasing in the future, find left half
                    r=mid-1;
                }else{
                    //this node is
                    if(target<nums[0]){
                        //in the right side
                        l=mid+1;
                    }else{
                        //in the right side
                        r=mid-1;
                    }
                }
            }else{
                return mid;
            }
        }
        return -1;
    }
    
}
