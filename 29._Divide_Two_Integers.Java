public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0)return Integer.MAX_VALUE;
        if(divisor==1)return dividend;
        if(dividend==0)return 0;
        return divideHelper((long)dividend,(long)divisor);
    }
    private int divideHelper(long dend,long dor){
        if(dend<0) return -divideHelper(-dend,dor);
        if(dor<0) return -divideHelper(dend,-dor);
        if(dor==1 && dend>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(dor==1) return (int) dend;
        if(dend<dor)return 0;
        int from=64-Long.numberOfLeadingZeros(dend-1);
        int res=0;
        for(;from>=0 && dend>0;from--){
            if(dend>=(dor<<from)){
                res+=1<<from;
                dend-=dor<<from;
            }
        }
        return res;
    }
    
}
