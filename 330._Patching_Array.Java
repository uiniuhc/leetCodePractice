public class Solution {
    public int minPatches(int[] nums, int n) {
        //nums is sorted!
        long canReach=1;
        int res=0;int i=0;
        if(nums.length==0 ||nums[0]!=1){
            res=1;i=0;
        }else{
            i=1;
        }
        
        while(canReach<n){
            if(i<nums.length && nums[i]<=canReach+1){
                canReach+=nums[i];i++;
            }else{
                canReach=2*canReach+1;res++;
            }
        }
        return res;
    }
}
