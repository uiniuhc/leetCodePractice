public class Solution {
    public int[] searchRange(int[] nums, int target) {
        boolean getL=false;boolean getR=false;
        int[] res={-1,-1};
        int sl=binarySearch(nums,target,0,nums.length-1);
        if(sl==-1){
            return res;
        }
        res[0]=sl;res[1]=sl;
        while(!getL || !getR){
            if(res[0]>0 && nums[res[0]-1]==target){
                res[0]=binarySearch(nums,target,0,res[0]-1);
            }else if((res[0]>0 && nums[res[0]-1]!=target)||res[0]==0){
                getL=true;
            }
            if(res[1]<nums.length-1 && nums[res[1]+1]==target){
                res[1]=binarySearch(nums,target,res[1]+1,nums.length-1);
            }else if((res[1]<nums.length-1 && nums[res[1]+1]!=target)||res[1]==nums.length-1){
                getR=true;
            }
        }
        return res;
    }
    public int binarySearch(int[] nums, int target, int s, int e){
        //if find target in s...e, return index
        //else return -1
        int l=s;int r=e;int mid=(l+r)/2;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}
