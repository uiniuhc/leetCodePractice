public class Solution {
    public void moveZeroes(int[] nums) {
        int pset=0;
        int psearch=0;
        while(psearch<nums.length){
            if(nums[psearch]!=0){
                nums[pset++]=nums[psearch];
            }
            psearch++;
        }
        while(pset<nums.length){
            nums[pset++]=0;
        }
    }
}
