public class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        int res=0;
        //if(target==)
        int [] opt=new int [target+1];
        for(int i=0;i<opt.length;i++)opt[i]=-1;
        opt[0]=0;
        return combineHelper(nums,target,opt);
    }
    private int combineHelper(int[] nums,int target,int [] opt){
        //if(target<=0 || target>=opt.length)return 0;
        if(opt[target]>=0)return opt[target];
        opt[target]=0;
        for(int i:nums){
            if(target>i){
                opt[target]+=combineHelper(nums,target-i,opt);
            }
            if(target==i){
                opt[target]+=1;
            }
        }
        return opt[target];
    }
    
}
