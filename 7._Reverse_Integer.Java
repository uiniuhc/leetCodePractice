public class Solution {
    public int reverse(int tx) {
        long x=tx;
        if(tx<0) x=-tx;
        long res=0;
        while(x>0){
            res=res*10+x%10;
            x/=10;
            if(res>Integer.MAX_VALUE)return 0;
        }
        if(tx<0) return (int)-res;
        return (int)res;
    }
}
