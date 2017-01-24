public class Solution {
    final char[] hexDig={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num==0)return "0";
        String res="";
        boolean init=true;
        for(int i=7;i>=0;i--){
            int temp=num & 15<<4*i;
            temp=temp>>>4*i;
            if(temp==0 && init )continue;
            res+=hexDig[temp];
            init=false;
        }
        return res;
    }
}
