public class Solution {
    
    public int minCut(String s) {
        char[] chs=s.toCharArray();
        //check all palindromes
        boolean[][] isPalindrome=new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            isPalindrome[i][i]=true;
            for(int j=i+1;j<s.length();j++){
                if(chs[i]==chs[j]){
                    if(i==j-1){
                        isPalindrome[i][j]=true;
                    }else{
                        isPalindrome[i][j]=isPalindrome[i+1][j-1];
                    }
                }
            }
        }
        //do the cuts
        int[] minCuts=new int[s.length()];
        for(int i=1;i<minCuts.length;i++){
            minCuts[i]=-1;
        }
        minCutHelper(chs, s.length()-1,minCuts,isPalindrome);
        return minCuts[s.length()-1];
        
        
    }
    private int minCutHelper(char[] chs, int j,int[] cuts,boolean[][] isP){
        if(cuts[j]!=-1)return cuts[j];
        int min=Integer.MAX_VALUE;
        for(int i=j;i>=0;i--){
            //from i to j is the last string
            if(isP[i][j]){
                if(i==0){
                    cuts[j]=0;return 0;
                }
                else{
                    //from 0 to i-1 is the first part of string
                    int t=1+minCutHelper(chs, i-1, cuts,isP);
                    if(t<min){
                        min=t;
                    }
                }
            }
        }
        cuts[j]=min;
        return min;
    }
}
