public class Solution {
    public int singleNumber(int[] nums) {
        int kk=0;
        for(int tt:nums){
            kk=kk^tt;
        }
        return kk;
    }
}
