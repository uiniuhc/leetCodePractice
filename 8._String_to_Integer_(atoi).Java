public class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        if(str.length()==0){
            return 0;
        }
        //get all digits
        long num=0;
        int i=0;
        boolean positive=true;
        //check for signal
        if(str.charAt(0)=='-'){
            i=1;positive=false;
        }else if(str.charAt(0)=='+'){
            i=1;positive=true;
        }
        for(;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                //error!
                break;
            }
            num=num*10+(str.charAt(i)-'0');
            if(i>11)break;
        }
        if(!positive)num=-num;
        if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)num;
    }
}
