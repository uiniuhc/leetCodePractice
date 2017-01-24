public class Solution {
    public int lastRemaining(int n) {
        int count=n;
        int last=n;
        int base=1;
        boolean left=true;
        while(count!=1){
            if(left && count%2==1){
                last-=base;
            }
            else if(!left){
                last-=base;
            }
            count/=2;
            left=!left;
            base*=2;
        }
        return last;
    }
}
