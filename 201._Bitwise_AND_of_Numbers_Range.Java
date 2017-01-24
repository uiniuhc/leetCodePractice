public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res=0;
        int dif=n-m;
        for(int i=0;i<32;i++){
            if(dif<(1<<i)){
                //may be zero, may be one
                if((m & n & (1<<i))>0){
                    //set this bit to 1
                    res |= 1<<i;
                }
            }
        }
        return res;
    }
}
