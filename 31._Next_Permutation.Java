public class Solution {
    private void reverseArr(int[] nums, int l, int r){
        while(l<r){
            int t=nums[r];
            nums[r]=nums[l];
            nums[l]=t;
            l++;r--;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length<=1)return;
        int last=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=last){
                //ok,nothing need to change
                last=nums[i];
            }else{
                //need change
                //find first one larger than it
                for(int j=nums.length-1;j>i;j--){
                    if(nums[j]>nums[i]){
                        //swap them 
                        int t=nums[i];
                        nums[i]=nums[j];
                        nums[j]=t;
                        break;
                    }
                }
                //reverse the part after i
                reverseArr(nums,i+1,nums.length-1);
                return;
            }
        }
        reverseArr(nums,0,nums.length-1);
    }
}
