public class Solution {
    public int countDigitOne(int n) {
        int base=1;
        int res=0;
        int m=n;
        while(m>0){
            res+=m/10*base;
            if(m%10==1){
                res+=n%base+1;
            }
            else if(m%10>1){
                res+=base;
            }
            m/=10;base*=10;
        }

        return res;
    }

}
