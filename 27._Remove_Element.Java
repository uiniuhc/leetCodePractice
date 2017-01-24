public class Solution {
    public int removeElement(int[] nums, int val) {
        int last=0;
        int count=0;
        if(nums.length==0)return 0;
        boolean flag=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[last++]=nums[i];
            }else{
                count++;
            }
        }
        return nums.length-count;
    }
}
