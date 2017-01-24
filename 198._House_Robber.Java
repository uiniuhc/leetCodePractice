public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        //int[] opt=new int[nums.length];
        int iMin1=-1;
        int iMin2=-1;
        int curr=0;
        int cMax=0;
        for(int i=0;i<nums.length;i++){
            curr=nums[i];
            if(iMin1<0){
                iMin1=curr;
                continue;
            }
            if(iMin2<0){
                iMin2=iMin1;
                if(curr>iMin1)iMin1=curr;
                continue;
            }
            if(curr+iMin2>iMin1){
                cMax=curr+iMin2;
            }else{
                cMax=iMin1;
            }
            iMin2=iMin1;
            iMin1=cMax;
        }
        return iMin1;
    }
}
