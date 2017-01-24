public class Solution {
    public String convertToTitle(int n) {
        if(n==0)return "";
        StringBuilder strb=new StringBuilder();
        while(n>0){
            strb.insert(0,(char)((n-1)%26+'A'));
            //if(n==26)break;
            n=(n-1)/26;
        }
    
        return strb.toString();
    }
    
}
