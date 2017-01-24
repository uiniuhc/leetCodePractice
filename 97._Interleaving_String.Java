public class Solution {
    public boolean isInterleave(String s3, String s2, String s1) {
        if(s1.length()!=s2.length()+s3.length()) {
            return false;
        }
        if(s2.length()==0){
            return s1.equals(s3);
        }
        if(s3.length()==0){
            return s1.equals(s2);
        }
        boolean[][] res=new boolean [s2.length()+1][s3.length()+1];
        char [] str1=s1.toCharArray();
        char [] str2=s2.toCharArray();
        char [] str3=s3.toCharArray();
        res[0][0]=true;
        for(int j=0;j<=s2.length();j++){
            for(int k=0;k<=s3.length();k++){
                if(j>0){
                    res[j][k]=res[j][k] || (str1[k+j-1]==str2[j-1] && res[j-1][k]);
                }
                if(k>0){
                    res[j][k]=res[j][k] || (str1[k+j-1]==str3[k-1] && res[j][k-1]);
                }
            }
        }    
        
        return res[s2.length()][s3.length()];
    }
}
