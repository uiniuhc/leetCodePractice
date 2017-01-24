/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l=0;long r=n;
        int mid=(int)((l+r)/2);
        while(l<=r){
            mid=(int)((l+r)/2);
            if(isBadVersion(mid)){
                if(l==r)return (int)mid;
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
