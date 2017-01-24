public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2)return nums.length;
        boolean decreasing=false;
        boolean first=true;
        int count=1;
        int last=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==last)continue;
            if(first){first=false;
                if(nums[i]<last)decreasing=true;
                else decreasing=false;
                count++;last=nums[i];continue;
            }
            if(decreasing && nums[i]>last){
                decreasing=false;count++;
            }
            else if(!decreasing && nums[i]<last){
                decreasing=true;count++;
            }
            last=nums[i];
        }
        return count;
    }
}
