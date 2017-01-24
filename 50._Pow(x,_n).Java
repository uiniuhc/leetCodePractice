public class Solution {
    public double myPow(double x, int n) {
        if(x==1)return 1;
        if(n==1)return x;
        if(n==0)return 1;
        if(n<0 && x!=0) return myPow(1./x, -(n+1))*(1/x);
        int d=n/2;
        double res=myPow(x,d);
        if(n%2==1)
        return res*res*x;
        else return res*res;
    }
}
