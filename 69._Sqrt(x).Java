public class Solution {
    public int mySqrt(int x) {
        if(x<=0)return x;
        if(x==1)return 1;
        //binary search
        int l=1;
        int r=x/2;
        int sqrt=0;
        while(l<=r){
            int mid=(l+r)/2;
            long res=(long)mid*mid;
            if( res==x){
                return mid;
            }else if(res>x){
                r=mid-1;
            }else{
                l=mid+1;
                sqrt=mid;//record result
            }
        }
        return sqrt;
    }
    
}
