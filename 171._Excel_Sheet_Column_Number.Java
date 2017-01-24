public class Solution {
    public int titleToNumber(String s) {
        if(s.length()==0)return 0;
        char [] str=s.trim().toCharArray();
        int base=1;
        int res=0;
        for(int i=str.length-1;i>=0;i--){
            if(str[i]<'A'||str[i]>'Z')continue;
            res+=(str[i]-'A'+1)*base;
            base*=26;
        }
        return res;
    }
}
