public class Solution {
    public int getSum(int a, int b) {
        boolean c=false;
        int res=0;
        int ta=a;
        int tb=b;
        for(int i=0;i<32;i++){
            int state=0;
            if((ta & (1<<i))!=0){
                state |= 1<<2;
            }
            if((tb & (1<<i))!=0){
                state |= 1<<1;
            }
            if(c){
                state |= 1;
            }
            if(state==3 || state==5 || state ==7 ||state ==6){
                c=true;//for next round
            }else{
                c=false;
            }
            if(state==7 || state==1 || state ==2 ||state==4){
                res |= 1<<i;
            }
        }
        return (int)res;
    }
}
