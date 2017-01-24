public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String prefix=strs[0];
        int max=prefix.length();
        for(String str:strs){
            for(int i=0;i<=max;i++){
                if(i==prefix.length() || i==str.length() || str.charAt(i)!=prefix.charAt(i)){
                    max=i;
                    if(max<0){
                        return "";
                    }
                    break;
                }
            }
        }
        return prefix.substring(0,max);
    }
}
