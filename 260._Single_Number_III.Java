public class Solution {
    public int[] singleNumber(int[] nums) {
        int xorRes=0;
        for(int i:nums)xorRes^=i;
        int mask=xorRes&(-xorRes);
        int [] res=new int[2];
        for(int i:nums){
            if((i&mask)==0){
                res[0]^=i;
            }else{
                res[1]^=i;
            }
        }
        return res;
    }
}
