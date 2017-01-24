public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[] res=new int[s.length()];
        return getBreak(s,wordDict,res,s.length()-1);
    }
    //string from 0 to n is valid?
    private boolean getBreak(String s, Set<String> wordDict, int[] res, int n){
        if(n<0)return false;
        if(res[n]!=0) return res[n]>0? true:false;
        for(int i=n;i>=0;i--){
            if(wordDict.contains(s.substring(i,n+1))){
                if(i==0 || getBreak(s,wordDict,res,i-1)){
                    res[n]=1;return true;
                }
            }
        }
        res[n]=-1; return false;
    }
}
