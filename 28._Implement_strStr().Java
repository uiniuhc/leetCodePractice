public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())return -1;
        if(needle.length()==0)return 0;
        char[] hay=haystack.toCharArray();
        char[] nee=needle.toCharArray();
        for(int i=0;i<=hay.length-nee.length;i++){
            int j;
            for(j=0;j<nee.length;j++){
                if(hay[i+j]!=nee[j]){
                    j=-1; break;
                }
            }
            if(j!=-1)return i;
        }
        return -1;
        
    }
}
