public class Solution {
    
    public int removeDuplicates(int[] nums) {
        int plast=0;
        if(nums.length==0){return 0;}
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[plast]){
                plast++;
                nums[plast]=nums[i];
            }
        }
        return plast+1;
    }
}
