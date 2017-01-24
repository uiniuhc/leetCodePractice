public class Solution {
    public String reverseString(String s) {
        if(s.length()<=1)return s;
        StringBuilder strb=new StringBuilder(s);
        strb.reverse();
        return strb.toString();
    }
}
