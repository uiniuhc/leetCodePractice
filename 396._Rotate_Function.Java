public class Solution {
    public int maxRotateFunction(int[] A) {
        long sum=0;
        if(A.length==0){
            return 0;
        }
        long f0=0;
        long large=0;
        for(int i=0;i<A.length;i++){
            f0+=i*A[i];
            sum+=A[i];
        }
        long last=f0;
        long max=last;
        int n=A.length;
        for(int i=n-1;i>0;i--){
            long fi=sum-(long)n*A[i]+last;
            last=fi;
            if(fi>max)max=fi;
        }
        return (int)max;
    }
}
