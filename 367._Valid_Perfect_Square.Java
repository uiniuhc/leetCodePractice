public class Solution {
    public boolean isPerfectSquare(int num) {
        int l=1;int r=num; int mid=(l+r)/2;
        while(l<=r){
            mid=(l+r)/2;
            long sq=(long)mid*mid;
            if(sq==(long)num){
                return true;
            }else if(sq<(long)num){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
        
    }
}
