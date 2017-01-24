public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res=new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        char c=0;
        while(i>=0 || j>=0){
            char ch1='0';
            char ch2='0';
            if(i>=0) ch1=num1.charAt(i);
            if(j>=0) ch2=num2.charAt(j);
            char temp=(char)((ch1-'0')+(ch2-'0')+c);
            if(temp>=10)c=1;
            else c=0;
            temp%=10;
            char ch=(char)(temp+'0');
            res.insert(0,ch);
            i--;j--;
        }
        if(c>0)res.insert(0,'1');
        return res.toString();
    }
}
