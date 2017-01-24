public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int iMin1=-1;
        int iMin2=-1;
        int curr=0;
        int cMax=0;
        for(int i=0;i<nums.length-1;i++){
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
        int max1=iMin1;
        iMin1=iMin2=-1;curr=0;cMax=0;
        for(int i=1;i<nums.length;i++){
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
        int max2=iMin1;
        if(max1>max2)return max1;
        return max2;
    }
 
}
