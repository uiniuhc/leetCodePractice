
public class Solution {
    public int integerBreak(int n) {
        int k=2;
        int res=1;
        int d,r,t;
        while(n/k>0){
            d=n/k;
            r=n%k;
            t=1;
            for(int i=0;i<k-r;i++){
                t*=d;
            }
            for(int i=0;i<r;i++){
                t*=(d+1);
            }
            if(t>res){
                res=t;
            }
            k++;
        }
        return res;
    }
}
