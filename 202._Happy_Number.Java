public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<Integer>();
        int res=n;
        set.add(res);
        while(res!=1){
            res=getDigitSum(res);
            if(set.contains(res))return false;//loop
            set.add(res);
        }
        return true;
    }
    private int getDigitSum(int i){
        int sum=0;
        while(i>0){
            int r=i%10;
            i/=10;
            sum+=(r*r);
        }
        return sum;
    }
}
