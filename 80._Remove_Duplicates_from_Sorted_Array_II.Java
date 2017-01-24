public class Solution {
    public int removeDuplicates(int[] nums) {
        int reduce=0;
        if(nums.length==0){
            return 0;
        }
        
        int [] res=new int[nums.length];
        int index=0;
        int lastoccur=nums[0];
        res[index++]=nums[0];
        int lastcount=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==lastoccur){
                lastcount++;
                if(lastcount>2){
                    reduce++;
                }else{
                    res[index++]=lastoccur;
                }
            }else{
                lastcount=1;
                lastoccur=nums[i];
                res[index++]=lastoccur;
            }
        }
        for(int i=1;i<index;i++){
            nums[i]=res[i];
        }
        return nums.length-reduce;
    }
}
