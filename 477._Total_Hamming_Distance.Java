public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int withZero=0;
            for(int j:nums) {
                if((j&(1<<i))==0)withZero++;
            }
            res+=withZero*(nums.length-withZero);
        }
        return res;
    }
}
