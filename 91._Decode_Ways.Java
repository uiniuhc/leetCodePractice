public class Solution {
    public int numDecodings(String s) {
        //s=trimZero(s);
        if(s.length()==0)return s.length();
        if(s.charAt(0)=='0')return 0;
        int[] nums=new int[s.length()];
        if(s.charAt(s.length()-1)!='0')nums[s.length()-1]=1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i+1)=='0' && s.charAt(i)!='1' && s.charAt(i)!='2')return 0;
            if(s.charAt(i)=='0') {
                nums[i]=nums[i+1]; 
                continue;
            }
            if((s.charAt(i)-'0')*10+s.charAt(i+1)-'0'<=26){
                if(i+2<s.length()) nums[i]+=nums[i+2];
                else nums[i]+=1;
            }
            if(s.charAt(i+1)!='0')nums[i]+=nums[i+1];
        }
        return nums[0];
    }

}
