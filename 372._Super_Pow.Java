public class Solution {
    public int superPow(int a, int[] b) {
        if(a==0 || a==1)return a;
        if(b.length==0)return 1;
        int res=1;
        int base=a;
        base%=1337;
        int temp;
        for(int i=b.length-1;i>=0;i--){
            for(int j=b[i];j>0;j--){
                res*=base;
                res%=1337;
            }
            //update base
            base*=base;//2
            base%=1337;
            temp=base;
            base*=base;//4
            base%=1337;
            base*=base;//8
            base%=1337;
            base*=temp;//10
            base%=1337;
        }
        return res;
    }
}
