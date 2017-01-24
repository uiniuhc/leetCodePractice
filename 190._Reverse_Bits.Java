public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i=0;i<16;i++){
            //swap the ith bit with 31-ith bit
            if((n&1<<i)==0 && (n&1<<(31-i))!=0){
                //set i to 1 31-i to 0
                n=n|1<<i;n=n&(~(1<<(31-i)));
            }else if((n&1<<i)!=0 && (n&1<<(31-i))==0){
                //set i to 0 31-i to 1
                n=n|1<<(31-i);n=n&(~(1<<i));
            }
        }
        return n;
    }
}
